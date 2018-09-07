package com.daily.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by json on 2018/9/7.
 * Describe: websocket 连接池
 * 线程池管理。
 */
public class WsPool {

    //websocket 连接池
    private final static Map<WebSocketServerDemo, String> wsMap = new HashMap<>();


    /**
     * 作者  json
     * 时间  2018/9/7 14:15
     * 描述  将websocket 添加 到连接池中
     **/
    public static void addWebSocket(WebSocketServerDemo webSocketServerDemo) {
        wsMap.put(webSocketServerDemo, webSocketServerDemo.getCurrentUser());
    }


    /**
     * 作者  json
     * 时间  2018/9/7 14:18
     * 描述 获取 websocket 链接 通过用户名
     **/
    public static WebSocketServerDemo getWebsSocketByUserName(String userName) {
        Set<WebSocketServerDemo> webSocketServerDemos = wsMap.keySet();
         WebSocketServerDemo webSocketServerDemo = new WebSocketServerDemo();
        webSocketServerDemos.forEach(o->{
            if (wsMap.get(o).equals(userName)){
                webSocketServerDemo.setCurrentUser(userName);
                webSocketServerDemo.setSession(o.getSession());
            }
        });
       return webSocketServerDemo;
    }


    /**
    *
    * 作者  json
    * 时间  2018/9/7 14:36
    * 描述 移除 websocket连接
    *
    **/
    public boolean removeWebSocket(WebSocketServerDemo webSocketServerDemo){
        boolean flag=false;
        flag = wsMap.remove(webSocketServerDemo, webSocketServerDemo.getCurrentUser());
        return flag;
    }
}
