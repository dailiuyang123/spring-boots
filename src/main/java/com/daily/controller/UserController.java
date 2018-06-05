package com.daily.controller;

import com.daily.mybatis.entity.JsonMessage;
import com.daily.utils.ParamUtils;
import com.daily.utils.ReadConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by json on 2018/6/5.
 * Describe:
 */
@RestController
@RequestMapping("/rest")
public class UserController {

    private Logger logger=LoggerFactory.getLogger(UserController.class);

    /**
    *
    * 作者  json
    * 时间  2018/6/5 15:04
    * 描述 获取个人信息的接口-从配置文件读取
    *
    **/

    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public JsonMessage getperson(HttpServletRequest request, HttpServletResponse response){
        JsonMessage jsonMessage=new JsonMessage();
        try {
            Map<String, String> stringStringMap = ReadConfig.readValue();
            jsonMessage.setData(stringStringMap);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            jsonMessage.setErrorCode("500");
            jsonMessage.setErrorMessage("内部错误");
        }
        return jsonMessage;

    }


}
