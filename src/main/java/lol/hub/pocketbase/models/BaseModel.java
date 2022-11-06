package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString
public abstract class BaseModel {
    String id;
    String created; // TODO: timestamp type
    String updated; // TODO: timestamp type

    public String id() {
        return id;
    }

    public String created() {
        return created;
    }

    public String updated() {
        return updated;
    }
}
