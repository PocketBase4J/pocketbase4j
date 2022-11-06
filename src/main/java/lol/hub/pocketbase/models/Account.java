package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Account extends BaseModel {
    String email;
    String lastResetSentAt; // TODO: timestamp type
}
