package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lol.hub.pocketbase.AuthRole;
import lol.hub.pocketbase.ApiClient;
import lol.hub.pocketbase.models.Admin;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.Page;
import lol.hub.pocketbase.models.transfer.LoginRequestBody;
import lol.hub.pocketbase.models.transfer.LoginResponseBody;

/**
 * <a href="https://pocketbase.io/docs/api-admins">api docs</a>
 */
public class AdminService extends BaseService {
    public AdminService(ApiClient http, Gson gson) {
        super(http, gson);
    }

    public boolean authViaEmail(String email, String password) throws ApiError {
        LoginResponseBody.Admin response = http.post("/api/admins/auth-via-email", gson.toJson(new LoginRequestBody(email, password)), LoginResponseBody.Admin.class);
        http.setAuth(AuthRole.ADMIN, response.getToken());
        boolean success = http.getAuth() == AuthRole.ADMIN;
        if (success) log.info("Logged in with role: admin");
        else log.warn("Login failed, current role: " + http.getAuth());
        return success;
    }

    public void authRefresh() throws ApiError {
        LoginResponseBody.Admin response = http.post("/api/admins/refresh", "", LoginResponseBody.Admin.class);
        http.setAuth(AuthRole.ADMIN, response.getToken());
    }

    public Page<Admin> listAdmins() throws ApiError {
        return http.get("/api/admins", TypeToken.getParameterized(Page.class, Admin.class).getType());
    }

    /* TODO:
	POST "/api/admins/request-password-reset"
	POST "/api/admins/confirm-password-reset"
	POST "/api/admins"
	GET "/api/admins/:id"
	PATCH "/api/admins/:id"
	DELETE "/api/admins/:id"
     */
}
