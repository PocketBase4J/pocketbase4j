package lol.hub.pocketbase.models;

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

    @Override
    public String toString() {
        return "Collection{" +
            "name='" + name + '\'' +
            ", system=" + system +
            ", schema=" + schema +
            ", listRule='" + listRule + '\'' +
            ", viewRule='" + viewRule + '\'' +
            ", createRule='" + createRule + '\'' +
            ", updateRule='" + updateRule + '\'' +
            ", deleteRule='" + deleteRule + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
