package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;

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

    @Override
    public String toString() {
        return "RequestLog{" +
            "url='" + url + '\'' +
            ", method='" + method + '\'' +
            ", status=" + status +
            ", auth='" + auth + '\'' +
            ", userIp='" + userIp + '\'' +
            ", remoteIp='" + remoteIp + '\'' +
            ", referer='" + referer + '\'' +
            ", userAgent='" + userAgent + '\'' +
            ", meta=" + meta +
            ", id='" + id + '\'' +
            ", created='" + created + '\'' +
            ", updated='" + updated + '\'' +
            '}';
    }
}
