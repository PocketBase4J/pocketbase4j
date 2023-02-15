package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.ApiClient;

/**
 * <a href="https://pocketbase.io/docs/api-realtime/">api docs</a>
 */
public class RealtimeService extends BaseService {
    public RealtimeService(ApiClient http, Gson gson) {
        super(http, gson);
    }

    /* TODO:
	GET  "/api/realtime"
	POST "/api/realtime"
	see: https://github.com/CiscoSE/commons-networking/blob/main/commons-networking/src/main/java/com/cisco/commons/networking/SSEClient.java
     */
}
