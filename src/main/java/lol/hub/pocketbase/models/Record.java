package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;

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

    @Override
    public String toString() {
        return "Record{" +
            "collection=" + collection +
            ", data=" + data +
            ", expand=" + expand +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
