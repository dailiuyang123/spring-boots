package com.daily.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by json on 2018/9/4.
 * Describe:  SpringBOOT 整合 Websocket 配置文件
 */

@Configuration
public class WebSocketConfig {

    //此种注解方式为 ：Java Config 注入对象。
    //Java Config 解读：比如第三方类库的组件, 可以使用java config的方式装配
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }
}