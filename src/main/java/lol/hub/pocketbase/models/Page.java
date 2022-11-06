package lol.hub.pocketbase.models;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Page{" +
            "page=" + page +
            ", perPage=" + perPage +
            ", totalItems=" + totalItems +
            ", totalPages=" + totalPages +
            ", items=" + Arrays.toString(items) +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
