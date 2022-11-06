package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Record extends BaseModel {
    Collection collection;
    JsonObject data;
    JsonObject expand;
}
