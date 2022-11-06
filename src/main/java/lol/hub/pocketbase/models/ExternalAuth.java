package lol.hub.pocketbase.models;

public class ExternalAuth extends BaseModel {
    String userId;
    String provider;
    String providerId;

    public String userId() {
        return userId;
    }

    public String provider() {
        return provider;
    }

    public String providerId() {
        return providerId;
    }

    @Override
    public String toString() {
        return "ExternalAuth{" +
            "userId='" + userId + '\'' +
            ", provider='" + provider + '\'' +
            ", providerId='" + providerId + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
