package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;

public class FileService extends BaseService {
    public FileService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    // TODO: GET "/api/files/:collection/:recordId/:filename"

}
