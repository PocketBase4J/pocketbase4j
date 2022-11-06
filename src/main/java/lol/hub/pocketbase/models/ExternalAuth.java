package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
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
}
