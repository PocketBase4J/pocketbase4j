package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
public class Account extends BaseModel {
    String email;
    String lastResetSentAt; // TODO: timestamp type

    public String email() {
        return email;
    }

    public String lastResetSentAt() {
        return lastResetSentAt;
    }
}
