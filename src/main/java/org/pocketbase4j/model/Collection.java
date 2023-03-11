package org.pocketbase4j.model;

import lombok.Getter;

@Getter
public class Collection extends BaseModel {
    private String name;

    private boolean system;

    // TODO: schema

    private String listRule;

    private String viewRule;

    private String createRule;

    private String updateRule;

    private String deleteRule;
}
