package lol.hub.pocketbase.services.auth;

import com.google.gson.Gson;
import lol.hub.pocketbase.ApiClient;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.transfer.AuthResponseBody;
import lol.hub.pocketbase.models.transfer.ConfirmPasswordResetRequestBody;
import lol.hub.pocketbase.models.transfer.LoginRequestBody;
import lol.hub.pocketbase.models.transfer.PasswordResetRequestBody;
import lol.hub.pocketbase.services.BaseService;

/**
 * <a href="https://pocketbase.io/docs/api-authentication">api docs</a>
 */
public abstract class BaseAuthService extends BaseService {
    public BaseAuthService(ApiClient http, Gson gson) {
        super(http, gson);
    }

    protected <T extends AuthResponseBody> T authWithPassword(String basePath, String identity, String password, Class<T> responseType) throws ApiError {
        return http.send("POST", basePath + "auth-with-password", gson.toJson(new LoginRequestBody(identity, password)), responseType);
    }

    protected <T extends AuthResponseBody> T authRefresh(String basePath, Class<T> responseType) throws ApiError {
        return http.send("POST", basePath + "auth-refresh", "", responseType);
    }

    protected boolean requestPasswordReset(String basePath, String email) throws ApiError {
        return http.send("POST", basePath + "request-password-reset", gson.toJson(new PasswordResetRequestBody(email)), Boolean.class);
    }

    protected boolean confirmPasswordReset(String basePath, String token, String password, String passwordConfirm) throws ApiError {
        return http.send("POST", basePath + "confirm-password-reset", gson.toJson(new ConfirmPasswordResetRequestBody(token, password, passwordConfirm)), Boolean.class);
    }
}
