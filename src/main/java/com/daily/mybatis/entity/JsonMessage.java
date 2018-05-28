package com.daily.mybatis.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by json on 2018/5/28.
 * Describe:
 */
public class JsonMessage implements Serializable {

    private String errorCode;
    private String errorMessage;
    private Map data;


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

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
