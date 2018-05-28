package com.daily.controller;

import com.daily.mybatis.entity.JsonMessage;
import com.daily.service.ArticleService;
import com.daily.utils.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Azir on 2018/5/27.
 *  文章管理
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private Logger logger=LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/createArticle",method = RequestMethod.POST)
    public String createArticle(HttpServletRequest request, HttpServletResponse response){
        Map param = ParamUtils.getParam(request);
        try {
            articleService.createArticle(param);
        }catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            return "内部错误";
        }
        return "插入成功";
    }


    /**
    *
    * 作者  json
    * 时间  2018/5/28 10:44
    * 描述 获取博客列表
    *
    **/
    @RequestMapping(value = "/getArticles",method = RequestMethod.POST)
    public JsonMessage getArticles(HttpServletRequest request,HttpServletResponse response){
        Map param = ParamUtils.getParam(request);
        JsonMessage jsonMessage=new JsonMessage();
        try {
            Map map = articleService.selectArticles(param);
            jsonMessage.setErrorCode("0");
            jsonMessage.setData(map);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            jsonMessage.setErrorCode("500");
            jsonMessage.setErrorMessage("内部错误");
        }
        return jsonMessage;
    }


    /**
    *
    * 作者  json
    * 时间  2018/5/28 11:32
    * 描述  获取 博客详情
    *
    **/
    @RequestMapping(value = "/articleDetail",method = RequestMethod.POST)
    public JsonMessage articleDetail(HttpServletRequest request,HttpServletResponse response){
        Map param = ParamUtils.getParam(request);
        JsonMessage jsonMessage=new JsonMessage();
        try {
            Map map = articleService.selectArticleById(param);
            jsonMessage.setErrorCode("0");
            jsonMessage.setData(map);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            jsonMessage.setErrorMessage("内部错误");
            jsonMessage.setErrorCode("500");
        }
        return jsonMessage;
    }


}
