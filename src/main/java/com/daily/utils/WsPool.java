package com.daily.utils;

import javax.websocket.Session;
import java.util.*;

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
    public static boolean removeWebSocket(Session session){
        final boolean[] flag = {false};
        Set<WebSocketServerDemo> webSocketServerDemos = wsMap.keySet();
        Iterator<WebSocketServerDemo> iterator = webSocketServerDemos.iterator();
        while (iterator.hasNext()){
            WebSocketServerDemo next = iterator.next();
            if (next.getSession().getId().equals(session.getId())){
                wsMap.remove(next);
                flag[0] =true;
            }

        }
        return flag[0];
    }

    /**
    *
    * 作者  json
    * 时间  2018/9/13 17:52
    * 描述 获取 所有的链接
    *
    **/
    public static Set<WebSocketServerDemo> getAllWebSockets(){
        return wsMap.keySet();
    }

}
