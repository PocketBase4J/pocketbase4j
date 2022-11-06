package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
public final class Page<T> extends BaseModel {
    int page;
    int perPage;
    int totalItems;
    int totalPages;
    T[] items;

    public int page() {
        return page;
    }

    public int perPage() {
        return perPage;
    }

    public int totalItems() {
        return totalItems;
    }

    public int totalPages() {
        return totalPages;
    }

    public T[] items() {
        return items;
    }
}
