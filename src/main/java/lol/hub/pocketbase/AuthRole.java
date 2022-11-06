package lol.hub.pocketbase;

public enum AuthRole {
    GUEST, USER, ADMIN;

    public String literal() {
        return this.name().toLowerCase();
    }

    public String authPrefix() {
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase() + " ";
    }
}
