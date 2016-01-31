package com.gem.server.model;

/**
 * Created by hoapham on 26/01/2016.
 */
public class ResponseObject {
    private boolean success;
    private String message;
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
