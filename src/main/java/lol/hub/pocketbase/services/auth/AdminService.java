package lol.hub.pocketbase.services.auth;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lol.hub.pocketbase.ApiClient;
import lol.hub.pocketbase.models.Admin;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.Page;
import lol.hub.pocketbase.models.transfer.*;

/**
 * <a href="https://pocketbase.io/docs/api-admins">api docs</a>
 */
public class AdminService extends BaseAuthService {
    public AdminService(ApiClient http, Gson gson) {
        super(http, gson);
    }

    public AuthResponseBody.Admin authWithPassword(String identity, String password) throws ApiError {
        return super.authWithPassword("/api/admins/", identity, password, AuthResponseBody.Admin.class);
    }

    public AuthResponseBody.Admin authRefresh() throws ApiError {
        return super.authRefresh("/api/admins/", AuthResponseBody.Admin.class);
    }

    public boolean requestPasswordReset(String email) throws ApiError {
        return super.requestPasswordReset("/api/admins/", email);
    }

    public boolean confirmPasswordReset(String token, String password, String passwordConfirm) throws ApiError {
        return super.confirmPasswordReset("/api/admins/", token, password, passwordConfirm);
    }

    // TODO: add missing parameters
    public Page<Admin> listAdmins() throws ApiError {
        return http.send("GET", "/api/admins", "", TypeToken.getParameterized(Page.class, Admin.class).getType());
    }

    public Admin viewAdmin(String id) throws ApiError {
        return http.send("GET", "/api/admins/" + id, "", Admin.class);
    }

    // TODO: check if avatar is between 0-9
    public Admin createAdmin(String id, String email, String password, String passwordConfirm, int avatar) throws ApiError {
        return http.send("GET", "/api/admins", gson.toJson(new AdminRequestBody(id, email, password, passwordConfirm, avatar)), Admin.class);
    }

    // TODO: check if avatar is between 0-9
    public Admin updateAdmin(String id, String email, String password, String passwordConfirm, int avatar) throws ApiError {
        return http.send("PATCH", "/api/admins/" + id, gson.toJson(new AdminRequestBody(id, email, password, passwordConfirm, avatar)), Admin.class);
    }

    public boolean deleteAdmin(String id) throws ApiError {
        return http.send("DELETE", "/api/admins/" + id, null, Boolean.class);
    }
}
