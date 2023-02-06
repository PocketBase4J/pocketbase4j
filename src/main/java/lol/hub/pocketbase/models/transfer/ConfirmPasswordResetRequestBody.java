package lol.hub.pocketbase.models.transfer;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ConfirmPasswordResetRequestBody {
    String token;
    String password;
    String passwordConfirm;

    public ConfirmPasswordResetRequestBody(String token, String password, String confirmPassword) {
        this.token = token;
        this.password = password;
        this.passwordConfirm = confirmPassword;
    }
}
