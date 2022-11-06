package lol.hub.pocketbase.models.transfer;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class LoginRequestBody {
    String email;
    String password;

    public LoginRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
