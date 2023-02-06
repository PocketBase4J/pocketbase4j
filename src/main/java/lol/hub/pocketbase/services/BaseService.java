package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
    final Logger log;
    final ApiClient http;
    final Gson gson;

    public BaseService(ApiClient http, Gson gson) {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.http = http;
        this.gson = gson;
    }
}
