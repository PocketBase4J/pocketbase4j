package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.ToString;

@ToString(callSuper = true)
public class RequestLog extends BaseModel {
    String url;
    String method;
    int status;
    String auth;
    String userIp;
    String remoteIp;
    String referer;
    String userAgent;
    JsonObject meta;

    public String url() {
        return url;
    }

    public String method() {
        return method;
    }

    public int status() {
        return status;
    }

    public String auth() {
        return auth;
    }

    public String userIp() {
        return userIp;
    }

    public String remoteIp() {
        return remoteIp;
    }

    public String referer() {
        return referer;
    }

    public String userAgent() {
        return userAgent;
    }

    public JsonObject meta() {
        return meta;
    }
}
