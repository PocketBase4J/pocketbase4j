package lol.hub.pocketbase.models;

public class Param extends BaseModel {
    String key;
    String value; // TODO: json type

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Param{" +
            "key='" + key + '\'' +
            ", value='" + value + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
