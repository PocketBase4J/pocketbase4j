package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;

public class Schema extends BaseModel {
    Field[] fields;

    public Field[] getFields() {
        return fields;
    }

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

        @Override
        public String toString() {
            return "Field{" +
                "system=" + system +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", required=" + required +
                ", unique=" + unique +
                ", options=" + options +
                '}';
        }
    }
}
