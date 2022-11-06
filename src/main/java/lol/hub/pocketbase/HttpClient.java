package lol.hub.pocketbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lol.hub.pocketbase.models.ApiError;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    private static final Map.Entry<String, String> contentTypeJsonHeader = Map.entry("Content-Type", "application/json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final URI baseUrl;
    private final java.net.http.HttpClient client;
    private final Map<String, String> headers = new HashMap<>();
    private AuthRole authRole;

    public HttpClient(URI baseUrl) {
        this.authRole = AuthRole.GUEST;
        this.baseUrl = baseUrl;
        this.client = java.net.http.HttpClient.newHttpClient();
        this.headers.put("User-Agent", "PocketBase-Java/0.1");
        this.headers.put("Accept", "application/json");
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

    public <T> T getJson(String path, Type responseBodyType) throws ApiError {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
            .uri(baseUrl.resolve(path))
            .GET();
        headers.forEach(builder::header);
        HttpRequest request = builder.build();
        String responseBody = send(request);
        return readBody(responseBody, responseBodyType);
    }

    public <T> T postJson(String path, String requestBody, Class<T> responseBodyType) throws ApiError {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
            .uri(baseUrl.resolve(path))
            .POST(HttpRequest.BodyPublishers.ofString(requestBody));
        headers.forEach(builder::header);
        builder.header(contentTypeJsonHeader.getKey(), contentTypeJsonHeader.getValue());
        HttpRequest request = builder.build();
        String responseBody = send(request);
        return readBody(responseBody, responseBodyType);
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
