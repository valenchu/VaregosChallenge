package com.varegos.varegos.handlerError;

import java.util.List;

public class ErrorResponse {

    private String code;
    private String id;
    private String message;
    private List<String> errors;
    private String errorCode;
    private String path;

    // Constructor
    public ErrorResponse(String code, String id, String message, List<String> errors, String errorCode, String path) {
        this.code = code;
        this.id = id;
        this.message = message;
        this.errors = errors;
        this.errorCode = errorCode;
        this.path = path;
    }

    // Getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}