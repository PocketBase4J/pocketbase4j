package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
public class LogStats extends BaseModel {
    double total;
    String date; // TODO: timestamp type

    public double total() {
        return total;
    }

    public String date() {
        return date;
    }
}
