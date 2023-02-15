package lol.hub.pocketbase;

import lol.hub.pocketbase.models.Admin;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ServiceTests {
    private static final String adminEmail = "admin@example.org";
    private static final String userEmail = "user@example.org";
    private static final String password = "correcthorsebatterystaple";

    private static PocketbaseClient adminClient;
    private static PocketbaseClient userClient;

    @BeforeAll
    static void beforeAll() throws ApiError {
        adminClient = new PocketbaseClient("127.0.0.1", 8090, true);
        adminClient.admins.authWithPassword(adminEmail, password);
        userClient = new PocketbaseClient("127.0.0.1", 8090, true);
        userClient.admins.authWithPassword(userEmail, password);
    }

    @Test
    void getAdminsAsAdmin() {
        Assertions.assertDoesNotThrow(() -> {
            Page<Admin> adminPage = adminClient.admins.listAdmins();
            Assertions.assertTrue(Arrays.stream(adminPage.getItems())
                .anyMatch(a -> a.getEmail().equals(adminEmail)));
        });
    }

    @Test
    void getAdminsAsUser() {
        ApiError error = Assertions.assertThrows(ApiError.class, () -> userClient.admins.listAdmins());
        Assertions.assertEquals(401, error.getCode());
    }

    @Test
    void getLogs() {
        Assertions.assertDoesNotThrow(() -> {
            adminClient.logs.listRequestLogs();
        });
    }

    @Test
    void getLogStats() {
        Assertions.assertDoesNotThrow(() -> {
            adminClient.logs.requestLogsStatistics();
        });
    }

    @Test
    void authRefreshAdmin() throws ApiError {
        adminClient.admins.authRefresh();
        // after token refresh, role should still be: admin
        // TODO: Assertions.assertEquals(AuthRole.ADMIN, adminClient.getAuthRole());
    }

    @Test
    void authRefreshUser() throws ApiError {
        userClient.admins.authRefresh();
        // after token refresh, role should still be: user
        // TODO: Assertions.assertEquals(AuthRole.USER, userClient.getAuthRole());
    }

    @Test
    void authRefreshGuest() throws ApiError {
        PocketbaseClient guestClient = new PocketbaseClient("127.0.0.1", 8090, true);
        // initially, auth role should be: guest
        // TODO: Assertions.assertEquals(AuthRole.GUEST, guestClient.getAuthRole());

        // TODO: implement logout -> guestClient.auth.lougout();
        // after guest login, role should still be: guest
        // TODO: Assertions.assertEquals(AuthRole.GUEST, guestClient.getAuthRole());

        guestClient.admins.authRefresh();
        // after token refresh, role should still be: guest
        // TODO: Assertions.assertEquals(AuthRole.GUEST, guestClient.getAuthRole());
    }

}
