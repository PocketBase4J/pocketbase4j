package lol.hub.pocketbase.models.transfer;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class AdminRequestBody {
    String id;
    String email;
    String password;
    String passwordConfirm;
    int avatar;

    public AdminRequestBody(String id, String email, String password, String passwordConfirm, int avatar) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.avatar = avatar;
    }
}
