package com.daily.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;


import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by json on 2018/5/16.
 * Describe: 远程调用 外部接口
 */
public class RemoteApiInvoke {

    private  String itil_url= "";         //被调用接口的url
    private  String itil_usernmae =  "";  //用户名
    private  String itil_passWorld = "";  //密码
    private  int itil_port ;            //端口号
    private  String itil_protocol = "http";//协议

    @Autowired
    HttpServletRequest request; //这里可以获取到request

    /**
    *
    * 作者  json
    * 时间  2018/5/16 17:23
    * 描述  调用远程接口
    *
    **/
    public Map invokeRemoteApi() throws IOException {

        String URL="";
        DefaultHttpClient httpClient=new DefaultHttpClient();

        HttpPost httpPost=new HttpPost("http://localhost:8888/lihe/rest/login.do");
//        List<NameValuePair> params=new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("name","admin"));
//        params.add(new BasicNameValuePair("password","1234qwer"));
//        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"utf-8");
//        httpPost.setEntity(entity);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","admin");
        jsonObject.put("password","1234qwer");
        StringEntity stringEntity= new StringEntity(jsonObject.toString(),"utf-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse execute = httpClient.execute(httpPost, (HttpContext) request);
        HttpEntity entity1 = execute.getEntity();
        String result = EntityUtils.toString(entity1);
        System.out.println(result+">>>>>>>>>>>>>>>>>>");
        return null;
    }



}
