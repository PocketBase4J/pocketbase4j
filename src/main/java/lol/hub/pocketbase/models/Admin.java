package lol.hub.pocketbase.models;

public class Admin extends Account {
    int avatar;

    public int avatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "avatar=" + avatar +
            ", email='" + email + '\'' +
            ", lastResetSentAt='" + lastResetSentAt + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
