package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.ApiClient;

/**
 * <a href="https://pocketbase.io/docs/api-records/">api docs</a>
 */
public class RecordService extends BaseService {
    public RecordService(ApiClient http, Gson gson) {
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
