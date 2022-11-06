package lol.hub.pocketbase.models.transfer;

import lombok.Getter;
import lombok.ToString;

public class LoginResponseBody {
    @Getter
    @ToString(callSuper = true)
    public static final class Admin {
        String token;
        Admin admin;
    }

    @Getter
    @ToString(callSuper = true)
    public static final class User {
        String token;
        User user;
    }
}
