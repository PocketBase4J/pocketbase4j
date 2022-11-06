package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import lol.hub.pocketbase.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
    final Logger log;
    final HttpClient http;
    final Gson gson;

    public BaseService(HttpClient http, Gson gson) {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.http = http;
        this.gson = gson;
    }
}
