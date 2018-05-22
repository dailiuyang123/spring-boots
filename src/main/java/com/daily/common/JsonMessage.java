package com.daily.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by json on 2018/5/21.
 * Describe:
 */
public class JsonMessage implements Serializable {

    private String errorCode;

    private String errorMessage;

    private HashMap data;

    @Override
    public String toString() {
        return "JsonMessage{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HashMap getData() {
        return data;
    }

    public void setData(HashMap data) {
        this.data = data;
    }
}
