package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
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
}
