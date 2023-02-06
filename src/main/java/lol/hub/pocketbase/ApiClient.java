package lol.hub.pocketbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lol.hub.pocketbase.models.ApiError;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private static final String HEADER_USER_AGENT = "PocketBase4J/0.1";
    private static final String HEADER_CONTENT_TYPE_JSON = "application/json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final URI baseUrl;
    private final HttpClient client;
    private final Map<String, String> headers = new HashMap<>();
    private AuthRole authRole;

    public ApiClient(URI baseUrl) {
        this.authRole = AuthRole.GUEST;
        this.baseUrl = baseUrl;
        this.client = HttpClient.newHttpClient();
        this.headers.put("User-Agent", HEADER_USER_AGENT);
        this.headers.put("Accept", HEADER_CONTENT_TYPE_JSON);
    }

    public static boolean isStatusOkay(int status) {
        return status >= 200 && status < 300;
    }

    public void setAuth(AuthRole role, String token) {
        if (role == AuthRole.GUEST || token == null || token.isEmpty()) {
            this.headers.remove("Authorization");
            this.authRole = AuthRole.GUEST;
        }
        this.headers.put("Authorization", role.authPrefix() + token);
        this.authRole = role;
    }

    public AuthRole getAuth() {
        return this.authRole;
    }

    private <T> T prepareRequest(String method, String path, HttpRequest.BodyPublisher bodyPublisher, Type responseBodyType, Map<String, String> headers) throws ApiError {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
            .uri(baseUrl.resolve(path))
            .method(method, bodyPublisher);
        headers.putAll(this.headers);
        headers.forEach(builder::header);
        return readBody(send(builder.build()), responseBodyType);
    }

    public <T> T get(String path, Type responseBodyType) throws ApiError {
        return prepareRequest("GET", path, HttpRequest.BodyPublishers.noBody(), responseBodyType, Collections.emptyMap());
    }

    public <T> T post(String path, String requestBody, Type responseBodyType) throws ApiError {
        return prepareRequest("POST", path, HttpRequest.BodyPublishers.ofString(requestBody), responseBodyType, Collections.singletonMap("Content-Type", HEADER_CONTENT_TYPE_JSON));
    }

    public <T> T put(String path, String requestBody, Type responseBodyType) throws ApiError {
        return prepareRequest("PUT", path, HttpRequest.BodyPublishers.ofString(requestBody), responseBodyType, Collections.singletonMap("Content-Type", HEADER_CONTENT_TYPE_JSON));
    }

    public <T> T patch(String path, String requestBody, Type responseBodyType) throws ApiError {
        return prepareRequest("PATCH", path, HttpRequest.BodyPublishers.ofString(requestBody), responseBodyType, Collections.singletonMap("Content-Type", HEADER_CONTENT_TYPE_JSON));
    }

    public <T> T delete(String path, Type responseBodyType) throws ApiError {
        return prepareRequest("DELETE", path, HttpRequest.BodyPublishers.noBody(), responseBodyType, Collections.emptyMap());
    }

    private String send(HttpRequest request) throws ApiError {
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
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
