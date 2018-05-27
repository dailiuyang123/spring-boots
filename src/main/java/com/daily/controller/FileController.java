package com.daily.controller;

import com.alibaba.fastjson.JSONObject;
import com.daily.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Azir on 2018/5/25.
 * 文件 管理模块
 */

@RestController
@RequestMapping("/file")
public class FileController {


    /**
    *  Author: 代刘洋
    *  Time：  2018/5/25  23:08
    *  Title:
    *  Param: 图片上传接口
    *  Response:
    *
    */
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public String uploadImages(HttpServletRequest request, HttpServletResponse response){

        FileUtils fileUtils=new FileUtils();
        Map map = fileUtils.FileUpload(request);
        String s = JSONObject.toJSONString(map);
        return s;

    }



}
