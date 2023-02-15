package lol.hub.pocketbase.stores;

import java.util.Optional;

public class BaseAuthStore {
    private String token;

    public BaseAuthStore() {
    }

    public BaseAuthStore(String token) {
        this.token = token;
    }

    public Optional<String> getToken() {
        if (token != null && token.isBlank()) return Optional.empty();
        return Optional.ofNullable(token);
    }

    public void setToken(String token) {
        this.token = token;
    }
}
