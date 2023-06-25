package com.nju.edu.network.web.response;

public enum StatusCode {
    SUCCESS(200, "ok"),
    BAD_REQUEST_DUPLICATED_KEY(400, "Bad request, duplicated key"),
    INTERNAL_SERVER_ERROR(500, "internal service error");

    int code;
    String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
