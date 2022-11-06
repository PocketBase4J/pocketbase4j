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
        adminClient.auth().loginAdmin(adminEmail, password);
        userClient = new PocketbaseClient("127.0.0.1", 8090, true);
        userClient.auth().loginUser(userEmail, password);
    }

    @Test
    void getAdminsAsAdmin() {
        Assertions.assertDoesNotThrow(() -> {
            Page<Admin> adminPage = adminClient.admins().listAdmins();
            Assertions.assertTrue(Arrays.stream(adminPage.items())
                .anyMatch(a -> a.email().equals(adminEmail)));
        });
    }

    @Test
    void getAdminsAsUser() {
        ApiError error = Assertions.assertThrows(ApiError.class, () -> userClient.admins().listAdmins());
        Assertions.assertEquals(401, error.code());
    }

    @Test
    void getLogs() {
        Assertions.assertDoesNotThrow(() -> {
            adminClient.logs().listRequestLogs();
        });
    }

    @Test
    void getLogStats() {
        Assertions.assertDoesNotThrow(() -> {
            adminClient.logs().requestLogsStatistics();
        });
    }

    @Test
    void authRefreshAdmin() throws ApiError {
        adminClient.auth().refreshToken();
        // after token refresh, role should still be: admin
        Assertions.assertEquals(AuthRole.ADMIN, adminClient.auth().currentRole());
    }

    @Test
    void authRefreshUser() throws ApiError {
        userClient.auth().refreshToken();
        // after token refresh, role should still be: user
        Assertions.assertEquals(AuthRole.USER, userClient.auth().currentRole());
    }

    @Test
    void authRefreshGuest() throws ApiError {
        PocketbaseClient guestClient = new PocketbaseClient("127.0.0.1", 8090, true);
        // initially, auth role should be: guest
        Assertions.assertEquals(AuthRole.GUEST, guestClient.auth().currentRole());

        guestClient.auth().lougout();
        // after guest login, role should still be: guest
        Assertions.assertEquals(AuthRole.GUEST, guestClient.auth().currentRole());

        guestClient.auth().refreshToken();
        // after token refresh, role should still be: guest
        Assertions.assertEquals(AuthRole.GUEST, guestClient.auth().currentRole());
    }

}
