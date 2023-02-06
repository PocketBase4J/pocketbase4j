package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.AuthRole;
import lol.hub.pocketbase.ApiClient;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.transfer.LoginRequestBody;
import lol.hub.pocketbase.models.transfer.LoginResponseBody;

/**
 * <a href="https://pocketbase.io/docs/api-users/">api docs</a>
 */
public class UserService extends BaseService {
    public UserService(ApiClient http, Gson gson) {
        super(http, gson);
    }

    public boolean authViaEmail(String email, String password) throws ApiError {
        LoginResponseBody.User response = http.post("/api/users/auth-via-email", gson.toJson(new LoginRequestBody(email, password)), LoginResponseBody.User.class);
        http.setAuth(AuthRole.USER, response.getToken());
        boolean success = http.getAuth() == AuthRole.USER;
        if (success) log.info("Logged in with role: user");
        else log.warn("Login failed, current role: " + http.getAuth());
        return success;
    }

    public void authRefresh() throws ApiError {
        LoginResponseBody.User response = http.post("/api/users/refresh", "", LoginResponseBody.User.class);
        http.setAuth(AuthRole.USER, response.getToken());
    }

    /* TODO:
	GET    "/api/users/auth-methods"
	POST   "/api/users/auth-via-oauth2"
	POST   "/api/users/request-password-reset"
	POST   "/api/users/confirm-password-reset"
	POST   "/api/users/request-verification"
	POST   "/api/users/confirm-verification"
	POST   "/api/users/request-email-change"
	POST   "/api/users/confirm-email-change"
	// TODO: crud
	GET    "/api/users"
	POST   "/api/users"
	GET    "/api/users/:id"
	PATCH  "/api/users/:id"
	DELETE "/api/users/:id"
	GET    "/api/users/:id/external-auths"
	DELETE "/api/users/:id/external-auths/:provider"
     */
}
