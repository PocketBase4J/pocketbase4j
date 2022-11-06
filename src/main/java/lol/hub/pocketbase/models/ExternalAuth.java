package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ExternalAuth extends BaseModel {
    String userId;
    String provider;
    String providerId;
}
