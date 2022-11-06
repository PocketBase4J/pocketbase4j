package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;

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

    @Override
    public String toString() {
        return "User{" +
            "verified=" + verified +
            ", lastVerificationSentAt='" + lastVerificationSentAt + '\'' +
            ", profile=" + profile +
            ", email='" + email + '\'' +
            ", lastResetSentAt='" + lastResetSentAt + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
