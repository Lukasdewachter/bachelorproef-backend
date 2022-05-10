package com.backend.UserManagement.Exception;

import java.util.Date;
import java.util.StringJoiner;

public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDescription() {
        return description;
    }

    public String toJson() {
        return new StringJoiner(", ", "{", "}")
                .add("\"timestamp\": \"" + timestamp + "\"")
                .add("\"status\": " + statusCode)
                .add("\"message\": \"" + message + "\"")
                .add("\"description\": \"" + description + "\"")
                .toString();
    }

}