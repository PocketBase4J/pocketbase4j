package org.pocketbase4j.model;

import lombok.Getter;

@Getter
public class Page<T extends BaseModel> {
    private int page;
    private int perPage;
    private int totalItems;
    private int totalPages;
    private T[] items;
}
