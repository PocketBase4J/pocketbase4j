package lol.hub.pocketbase.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class LogStats extends BaseModel {
    double total;
    String date; // TODO: timestamp type
}
