package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class User extends Account {
    boolean verified;
    String lastVerificationSentAt; // TODO: timestamp type
    JsonObject profile;
}
