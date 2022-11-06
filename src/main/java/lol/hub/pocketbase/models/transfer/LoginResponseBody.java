package lol.hub.pocketbase.models.transfer;

public class LoginResponseBody {
    public record Admin(String token, Admin admin) {
    }

    public record User(String token, User user) {
    }
}
