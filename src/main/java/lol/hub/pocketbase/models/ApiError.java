package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.ToString;

@ToString
public class ApiError extends Exception {
    int code;
    String message;
    JsonObject data;

    public ApiError(int code, String message, JsonObject data) {
        super("code=" + code + ", message='" + message + '\'' + ", data=" + data);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int code() {
        return code;
    }

    public String message() {
        return getMessage();
    }

    public JsonObject data() {
        return data;
    }
}
