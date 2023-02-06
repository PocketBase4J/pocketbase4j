package lol.hub.pocketbase.models.transfer;

import lombok.Getter;
import lombok.ToString;

public class AuthResponseBody {
    @Getter
    @ToString(callSuper = true)
    public class Admin extends AuthResponseBody {
        String token;
        Admin admin;
    }

    @Getter
    @ToString(callSuper = true)
    public class User extends AuthResponseBody {
        String token;
        User user;
    }
}
