package org.pocketbase4j.exceptions;

public class PocketbaseException extends Exception {
    private int status;
    private String message;

    public PocketbaseException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
