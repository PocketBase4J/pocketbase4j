package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Schema extends BaseModel {
    Field[] fields;

    @Getter
    @ToString(callSuper = true)
    private static class Field {
        boolean system;
        String id;
        String name;
        String type;
        boolean required;
        boolean unique;
        JsonObject options;
    }
}
