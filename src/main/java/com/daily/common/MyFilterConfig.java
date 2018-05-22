package com.daily.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 2018/5/22.
 * Describe:
 */
@Configuration
public class MyFilterConfig {

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        //拦截规则
        //registration.addUrlPatterns(".html");
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/talk/*");
        registration.setUrlPatterns(urlPatterns);
        //过滤器名称
        registration.setName("MyFilter");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(false);
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean(name = "MyFilter")
    public Filter MyFilter() {
        return new MyFilter();
    }

}
