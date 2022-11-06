package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lol.hub.pocketbase.HttpClient;
import lol.hub.pocketbase.models.Admin;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.Page;

/**
 * <a href="https://pocketbase.io/docs/api-admins">api docs</a>
 */
public class AdminService extends BaseService {
    public AdminService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    /* TODO:
	POST   "/api/admins/request-password-reset"
	POST   "/api/admins/confirm-password-reset"
	POST   "/api/admins"
	GET    "/api/admins/:id"
	PATCH  "/api/admins/:id"
	DELETE "/api/admins/:id"
     */

    public Page<Admin> getAdmins() throws ApiError {
        return http.getJson("/api/admins", TypeToken.getParameterized(Page.class, Admin.class).getType());
    }
}
