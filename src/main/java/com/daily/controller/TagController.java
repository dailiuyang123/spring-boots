package com.daily.controller;

import com.daily.mybatis.entity.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by json on 2018/6/7.
 * Describe:标签页控制类
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    Logger logger= LoggerFactory.getLogger(TagController.class);

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public JsonMessage tagList(HttpServletRequest request, HttpServletResponse response){
        JsonMessage jsonMessage=new JsonMessage();
        try {


        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return jsonMessage;
    }

}
