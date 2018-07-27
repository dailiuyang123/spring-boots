package com.daily.WSDLTest;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by json on 2018/7/26.
 * Describe: 调用 以wsdl 方式 发布服务 的demo
 */
public class Wsdl {


    // wsdl  方式访问 webservice 服务
    // 提供 wsdl url=http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl
    // 国内火车 列次查询服务
    @Test
    public  void testWsdlByGet() throws IOException {

        // httpclient
        CloseableHttpClient client= HttpClients.createDefault();

        // 填写数据，发送get或者post请求
        String number="156123456";
        HttpGet httpget = new HttpGet("http://ws.webxml.com.cn/WebServices/TrainTimeWebService.asmx/getStationAndTimeDataSetByTrainCode?TrainCode=G72&UserID=");
        httpget.setHeader("Content-Type","text/xml; charset=utf-8");
        CloseableHttpResponse execute = client.execute(httpget);
        HttpEntity entity = execute.getEntity();
        String content = EntityUtils.toString(entity);
        System.out.println("响应结果"+content);


    }

}
