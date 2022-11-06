package lol.hub.pocketbase.models;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

@Getter
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
}
