package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lol.hub.pocketbase.ApiClient;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.Page;
import lol.hub.pocketbase.models.Record;

/**
 * <a href="https://pocketbase.io/docs/api-records/">api docs</a>
 */
public class RecordService extends BaseService {
    public RecordService(ApiClient http, Gson gson) {
        super(http, gson);
    }

    // TODO: add missing parameters
    public Page<Record> listRecords(String collectionIdOrName) throws ApiError {
        return http.send("GET", "/api/collections/" + collectionIdOrName + "/records", "", TypeToken.getParameterized(Page.class, Record.class).getType());
    }

    // TODO: add missing parameters
    public Record viewRecord(String collectionIdOrName, String recordId) throws ApiError {
        return http.send("GET", "/api/collections/" + collectionIdOrName + "/records/" + recordId, "", Record.class);
    }

    // TODO: implement missing methods
}
