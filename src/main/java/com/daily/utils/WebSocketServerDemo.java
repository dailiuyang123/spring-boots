package com.daily.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by json on 2018/9/4.
 * Describe: Websocket 服务端 测试
 */
@Component
@ServerEndpoint("/ws")
public class WebSocketServerDemo {
    private Logger logger =LoggerFactory.getLogger(WebSocketServerDemo.class);

    private String currentUser;


    //连接打开时执行
    @OnOpen
    public void onOpen(Session session) {
        logger.error("连接部分已执行。。。。");
        currentUser = "tom";
        System.out.println("Connected ... " + session.getId());
    }

    //收到消息时执行
    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println(currentUser + "：" + message);
        return currentUser + "：" + message;
    }

    //连接关闭时执行
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

    //连接错误时执行
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }


}
