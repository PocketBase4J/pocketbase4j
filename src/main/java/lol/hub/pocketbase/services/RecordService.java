package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;

public class RecordService extends BaseService {
    public RecordService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    /* TODO:
	GET    "/api/collections/:collection/records"
	POST   "/api/collections/:collection/records"
	GET    "/api/collections/:collection/records/:id"
	PATCH  "/api/collections/:collection/records/:id"
	DELETE "/api/collections/:collection/records/:id"
     */
}
