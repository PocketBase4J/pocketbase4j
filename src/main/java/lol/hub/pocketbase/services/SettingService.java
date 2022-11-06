package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;

public class SettingService extends BaseService {
    public SettingService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    /* TODO:
	GET   "/api/settings"
	PATCH "/api/settings"
	POST  "/api/settings/test/s3"
	POST  "/api/settings/test/email"
     */
}
