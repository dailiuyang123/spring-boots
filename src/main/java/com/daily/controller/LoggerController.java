package com.daily.controller;


import com.daily.common.JsonMessage;
import com.daily.utils.FileReaderUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by json on 2018/5/21.
 * Describe:  日志处理
 */
@RestController
@RequestMapping("/logger")
public class LoggerController {

    /**
    *
    * 作者  json
    * 时间  2018/5/21 14:53
    * 描述 执行 sql语句
    *
    **/
    @RequestMapping(value = "/invokeLogger",method = RequestMethod.GET)
    public JsonMessage invokeLogger(HttpServletRequest request, HttpServletResponse response){

        String path="D:\\localhost_access_log.2018-05-17.txt";
        try {
            //FileReaderUtil.readByInputStream(path);
            FileReaderUtil.readByReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}
