package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
public class Collection extends BaseModel {
    String name;
    boolean system;
    Schema schema;
    String listRule;
    String viewRule;
    String createRule;
    String updateRule;
    String deleteRule;

    public String name() {
        return name;
    }

    public boolean system() {
        return system;
    }

    public Schema schema() {
        return schema;
    }

    public String listRule() {
        return listRule;
    }

    public String viewRule() {
        return viewRule;
    }

    public String createRule() {
        return createRule;
    }

    public String updateRule() {
        return updateRule;
    }

    public String deleteRule() {
        return deleteRule;
    }
}
