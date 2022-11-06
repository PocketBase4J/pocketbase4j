package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.ToString;

@ToString(callSuper = true)
public class User extends Account {
    boolean verified;
    String lastVerificationSentAt; // TODO: timestamp type
    JsonObject profile;

    public boolean verified() {
        return verified;
    }

    public String lastVerificationSentAt() {
        return lastVerificationSentAt;
    }

    public JsonObject profile() {
        return profile;
    }
}
