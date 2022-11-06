package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.ToString;

@ToString(callSuper = true)
public class Record extends BaseModel {
    Collection collection;
    JsonObject data;
    JsonObject expand;

    public Collection collection() {
        return collection;
    }

    public JsonObject data() {
        return data;
    }

    public JsonObject expand() {
        return expand;
    }
}
