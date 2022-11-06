package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.AuthRole;
import lol.hub.pocketbase.HttpClient;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.transfer.LoginRequestBody;
import lol.hub.pocketbase.models.transfer.LoginResponseBody;

public class AuthService extends BaseService {
    public AuthService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    public boolean loginAdmin(String email, String password) throws ApiError {
        LoginResponseBody.Admin response = http.postJson("/api/admins/auth-via-email", gson.toJson(new LoginRequestBody(email, password)), LoginResponseBody.Admin.class);
        http.setAuth(AuthRole.ADMIN, response.token());
        boolean success = currentRole() == AuthRole.ADMIN;
        if (success) log.info("Logged in with role: admin");
        else log.warn("Login failed, actual role: " + currentRole());
        return success;
    }

    public boolean loginUser(String email, String password) throws ApiError {
        LoginResponseBody.User response = http.postJson("/api/users/auth-via-email", gson.toJson(new LoginRequestBody(email, password)), LoginResponseBody.User.class);
        http.setAuth(AuthRole.USER, response.token());
        boolean success = currentRole() == AuthRole.USER;
        if (success) log.info("Logged in with role: user");
        else log.warn("Login failed, actual role: " + currentRole());
        return success;
    }

    public boolean loginGuest() {
        http.setAuth(AuthRole.GUEST, null);
        boolean success = currentRole() == AuthRole.GUEST;
        if (success) log.info("Logged in with role: guest");
        else log.warn("Login failed, actual role: " + currentRole());
        return success;
    }

    public void refreshToken() throws ApiError {
        switch (currentRole()) {
            case ADMIN -> {
                LoginResponseBody.Admin response = http.postJson("/api/admins/refresh", "", LoginResponseBody.Admin.class);
                http.setAuth(AuthRole.ADMIN, response.token());
            }
            case USER -> {
                LoginResponseBody.User response = http.postJson("/api/users/refresh", "", LoginResponseBody.User.class);
                http.setAuth(AuthRole.USER, response.token());
            }
            case GUEST -> http.setAuth(AuthRole.GUEST, null);
        }
    }

    public AuthRole currentRole() {
        return http.getAuth();
    }

    // TODO: GET  /api/users/auth-methods
    // TODO: POST /api/users/auth-via-oauth2

}
