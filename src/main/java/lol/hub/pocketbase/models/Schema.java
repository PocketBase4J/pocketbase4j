package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.ToString;

@ToString(callSuper = true)
public class Schema extends BaseModel {
    Field[] fields;

    public Field[] getFields() {
        return fields;
    }

    @ToString(callSuper = true)
    private static class Field {
        boolean system;
        String id;
        String name;
        String type;
        boolean required;
        boolean unique;
        JsonObject options;

        public boolean system() {
            return system;
        }

        public String id() {
            return id;
        }

        public String name() {
            return name;
        }

        public String type() {
            return type;
        }

        public boolean required() {
            return required;
        }

        public boolean unique() {
            return unique;
        }

        public JsonObject options() {
            return options;
        }
    }
}
