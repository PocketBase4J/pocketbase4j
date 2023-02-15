package lol.hub.pocketbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.stores.BaseAuthStore;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private static final String HEADER_USER_AGENT = "PocketBase4J/0.1";
    private static final String HEADER_CONTENT_TYPE_JSON = "application/json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final URI baseUrl;
    private final HttpClient httpClient;
    private final Map<String, String> headers = new HashMap<>();
    private final BaseAuthStore authStore;

    public ApiClient(URI baseUrl) {
        this(baseUrl, new BaseAuthStore());
    }

    public ApiClient(URI baseUrl, BaseAuthStore authStore) {
        this.baseUrl = baseUrl;
        this.authStore = authStore;
        this.httpClient = HttpClient.newHttpClient();
        this.headers.put("User-Agent", HEADER_USER_AGENT);
        this.headers.put("Accept", HEADER_CONTENT_TYPE_JSON);
    }

    public static boolean isStatusOkay(int status) {
        return status >= 200 && status < 300;
    }

    public <T> T send(String method, String path, String requestBody, Type responseBodyType) throws ApiError {
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.noBody();
        if (requestBody != null && !requestBody.isBlank()) {
            bodyPublisher = HttpRequest.BodyPublishers.ofString(requestBody);
            this.headers.put("Content-Type", HEADER_CONTENT_TYPE_JSON);
        }
        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
            .uri(baseUrl.resolve(path))
            .method(method, bodyPublisher);
        this.headers.forEach(reqBuilder::header);
        this.authStore.getToken().ifPresent(token -> reqBuilder.header("Authorization", token));
        return readBody(send(reqBuilder.build()), responseBodyType);
    }

    private String send(HttpRequest request) throws ApiError {
        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!isStatusOkay(response.statusCode())) {
            throw readError(response.body());
        }
        return response.body();
    }

    private <T> T readBody(String body, Type type) {
        if (body == null) {
            System.err.println("Response body is empty!");
        }
        return gson.fromJson(body, type);
    }

    private ApiError readError(String body) {
        return readBody(body, ApiError.class);
    }
}
