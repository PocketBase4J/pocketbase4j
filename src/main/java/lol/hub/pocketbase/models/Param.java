package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Param extends BaseModel {
    String key;
    String value; // TODO: json type
}
