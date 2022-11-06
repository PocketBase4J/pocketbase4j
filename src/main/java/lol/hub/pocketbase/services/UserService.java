package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;

/**
 * <a href="https://pocketbase.io/docs/api-users/">api docs</a>
 */
public class UserService extends BaseService {
    public UserService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    /* TODO:
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
