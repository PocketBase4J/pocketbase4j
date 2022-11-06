package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class BaseModel {
    String id;
    String created; // TODO: timestamp type
    String updated; // TODO: timestamp type
}
