package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.AuthRole;
import lol.hub.pocketbase.ApiClient;
import lol.hub.pocketbase.models.ApiError;

/**
 * <a href="https://pocketbase.io/docs/api-authentication">api docs</a>
 */
public class AuthService extends BaseService {
    private final AdminService adminService;
    private final UserService userService;

    public AuthService(ApiClient http, Gson gson, AdminService adminService, UserService userService) {
        super(http, gson);
        this.adminService = adminService;
        this.userService = userService;
    }

    public boolean loginAdmin(String email, String password) throws ApiError {
        return adminService.authViaEmail(email, password);
    }

    public boolean loginUser(String email, String password) throws ApiError {
        return userService.authViaEmail(email, password);
    }

    public boolean lougout() {
        http.setAuth(AuthRole.GUEST, null);
        boolean success = currentRole() == AuthRole.GUEST;
        if (success) log.info("Logged out, role: guest");
        else log.warn("Logout failed, current role: " + currentRole());
        return success;
    }

    public void refreshToken() throws ApiError {
        switch (currentRole()) {
            case ADMIN -> {
                adminService.authRefresh();
            }
            case USER -> {
                userService.authRefresh();
            }
            case GUEST -> http.setAuth(AuthRole.GUEST, null);
        }
    }

    public AuthRole currentRole() {
        return http.getAuth();
    }
}
