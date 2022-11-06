package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class Page<T> extends BaseModel {
    int page;
    int perPage;
    int totalItems;
    int totalPages;
    T[] items;
}
