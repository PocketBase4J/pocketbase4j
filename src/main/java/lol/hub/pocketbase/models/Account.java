package lol.hub.pocketbase.models;

public class Account extends BaseModel {
    String email;
    String lastResetSentAt; // TODO: timestamp type

    public String email() {
        return email;
    }

    public String lastResetSentAt() {
        return lastResetSentAt;
    }

    @Override
    public String toString() {
        return "Account{" +
            "email='" + email + '\'' +
            ", lastResetSentAt='" + lastResetSentAt + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
