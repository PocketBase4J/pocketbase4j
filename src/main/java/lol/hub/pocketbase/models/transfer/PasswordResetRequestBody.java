package lol.hub.pocketbase.models.transfer;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PasswordResetRequestBody {
    String email;

    public PasswordResetRequestBody(String email) {
        this.email = email;
    }
}
