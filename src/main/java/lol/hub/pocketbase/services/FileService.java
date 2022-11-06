package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;

/**
 * <a href="https://pocketbase.io/docs/api-files/">api docs</a>
 */
public class FileService extends BaseService {
    public FileService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    // TODO: GET "/api/files/:collection/:recordId/:filename"

}
