package com.daily.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by json on 2018/9/4.
 * Describe: Websocket协议  服务端 测试   全双工
 *      OAQ: WebSocket是HTML5开始提供的一种在单个 TCP 连接上进行全双工通讯的协议
 */
@Component
@ServerEndpoint("/ws")
public class WebSocketServerDemo {
    private Logger logger =LoggerFactory.getLogger(WebSocketServerDemo.class);

    private String currentUser;


    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private  Session session;
    //连接打开时执行
    @OnOpen
    public void onOpen(Session session) {
        logger.error("连接部分已执行。。。。");
        currentUser = "tom";
        this.session=session;
        System.out.println("Connected ... " + session.getId());
    }

    //收到消息时执行
    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println(currentUser + "：" + message);
        //这里执行推送代码
        boolean userName = message.startsWith("userName");
        if (userName){
            int i = message.indexOf(":");
            String user = message.substring(i+1);
            System.out.println("用户名："+user);
            this.setCurrentUser(user);
            //将此链接 加入到连接池中
            WsPool.addWebSocket(this);
        }

        try {
            this.sendMessage("服务端已经收到！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentUser + "服务端 ：" + message;
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



    /**
    *
    * 作者  json
    * 时间  2018/9/7 11:40
    * 描述 发送消息
    *
    **/
    public  void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        logger.error("服务端推送消息："+message);
    }


    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
