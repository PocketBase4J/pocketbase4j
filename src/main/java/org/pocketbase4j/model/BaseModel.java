package org.pocketbase4j.model;

import lombok.Getter;

@Getter
public abstract class BaseModel {
    public String id;
    public String created;
    public String updated;
}
