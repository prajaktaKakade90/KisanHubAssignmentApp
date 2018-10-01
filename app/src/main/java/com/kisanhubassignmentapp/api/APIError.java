package com.kisanhubassignmentapp.api;

/**
 * Created by @author Prajakta on 27-09-2018.
 */

public class APIError {

    private String statusCode;


    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}
