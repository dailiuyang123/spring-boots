package com.daily.common;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by json on 2018/9/13.
 * Describe:
 */
public class Message implements Serializable{

    //消息状态 标记
    private String flag;

    //消息 内容
    private String data;

    //消息 发送人
    private String user;

    //发送时间
    private Date date;

    //当前在线人数
    private Long online;


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOnline() {
        return online;
    }

    public void setOnline(Long online) {
        this.online = online;
    }
}
