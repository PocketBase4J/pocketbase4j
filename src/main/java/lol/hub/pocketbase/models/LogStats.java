package lol.hub.pocketbase.models;

public class LogStats extends BaseModel {
    double total;
    String date; // TODO: timestamp type

    public double total() {
        return total;
    }

    public String date() {
        return date;
    }

    @Override
    public String toString() {
        return "LogStats{" +
            "total=" + total +
            ", date='" + date + '\'' +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
