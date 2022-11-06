package lol.hub.pocketbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lol.hub.pocketbase.services.*;

import java.net.URI;
import java.net.URISyntaxException;

public class PocketbaseClient {
    private final AuthService auth;
    private final AdminService admins;
    private final CollectionService collections;
    private final FileService files;
    private final LogService logs;
    private final RealtimeService realtime;
    private final RecordService records;
    private final SettingService settings;
    private final UserService users;

    public PocketbaseClient(String host, int port, boolean insecure) {
        HttpClient http = new HttpClient(buildBaseUri(host, port, insecure));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        this.admins = new AdminService(http, gson);
        this.users = new UserService(http, gson);
        this.auth = new AuthService(http, gson, admins, users);
        this.collections = new CollectionService(http, gson);
        this.files = new FileService(http, gson);
        this.logs = new LogService(http, gson);
        this.realtime = new RealtimeService(http, gson);
        this.records = new RecordService(http, gson);
        this.settings = new SettingService(http, gson);
    }

    private static URI buildBaseUri(String host, int port, boolean insecure) {
        String protocol = insecure ? "http" : "https";
        try {
            return new URI(protocol + "://" + host + ":" + port + "/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public AuthService auth() {
        return auth;
    }

    public AdminService admins() {
        return admins;
    }

    public CollectionService collections() {
        return collections;
    }

    public FileService files() {
        return files;
    }

    public LogService logs() {
        return logs;
    }

    public RealtimeService realtime() {
        return realtime;
    }

    public RecordService records() {
        return records;
    }

    public SettingService settings() {
        return settings;
    }

    public UserService users() {
        return users;
    }
}
