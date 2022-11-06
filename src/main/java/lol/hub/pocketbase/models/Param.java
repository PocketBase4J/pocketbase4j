package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
public class Param extends BaseModel {
    String key;
    String value; // TODO: json type

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }
}
