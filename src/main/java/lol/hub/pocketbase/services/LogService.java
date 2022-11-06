package lol.hub.pocketbase.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lol.hub.pocketbase.HttpClient;
import lol.hub.pocketbase.models.ApiError;
import lol.hub.pocketbase.models.LogStats;
import lol.hub.pocketbase.models.Page;
import lol.hub.pocketbase.models.RequestLog;

import java.util.List;

public class LogService extends BaseService {
    public LogService(HttpClient http, Gson gson) {
        super(http, gson);
    }

    // TODO: GET "/api/logs/requests/:id"

    /**
     * GET /api/logs/requests
     */
    public Page<RequestLog> getLogs() throws ApiError {
        return http.getJson("/api/logs/requests", TypeToken.getParameterized(Page.class, RequestLog.class).getType());
    }

    /**
     * GET /api/logs/requests/stats
     */
    public List<LogStats> getLogStats() throws ApiError {
        return http.getJson("/api/logs/requests/stats", TypeToken.getParameterized(List.class, LogStats.class).getType());
    }
}
