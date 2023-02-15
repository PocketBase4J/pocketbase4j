package lol.hub.pocketbase.stores;

public class BaseAuthStore {
    private String token;

    public BaseAuthStore() {
    }

    public BaseAuthStore(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
