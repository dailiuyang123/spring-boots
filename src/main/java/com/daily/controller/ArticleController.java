package com.daily.controller;

import com.daily.service.ArticleService;
import com.daily.utils.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

}
