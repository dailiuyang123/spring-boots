package com.daily.common;



import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by json on 2018/5/22.
 * Describe:自定义 拦截器
 */

public class MyFilter implements Filter {

    private org.slf4j.Logger logger=LoggerFactory.getLogger(MyFilter.class);





    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
    *
    * 作者  json
    * 时间  2018/5/22 16:08
    * 描述 请求 拦截
    *
    **/
    @Override
    public void doFilter(ServletRequest requestt, ServletResponse responset, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) requestt;
        HttpServletResponse httpresponse = (HttpServletResponse) responset;
        String requestURI = httprequest.getRequestURI();
        System.out.println("请求路径："+requestURI);
        logger.error(requestURI);
        //设置编码解码格式为：UTF-8
        httprequest.setCharacterEncoding("UTF-8");
        httpresponse.setCharacterEncoding("UTF-8");

        String method = httprequest.getMethod();
        System.out.println("请求方式:"+method);

        chain.doFilter(httprequest,httpresponse);
    }

    @Override
    public void destroy() {

    }


}
