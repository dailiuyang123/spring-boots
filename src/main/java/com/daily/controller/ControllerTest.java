package com.daily.controller;

import com.alibaba.fastjson.JSONArray;
import com.daily.mybatis.dao.TalkMapper;
import com.daily.mybatis.entity.Talk;
import com.daily.mybatis.entity.TalkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by json on 2018/5/8.
 * Describe:
 */
@RestController
@RequestMapping(value = "/Talk")
public class ControllerTest {
    @Autowired
    private TalkMapper talkMapper;

    @GetMapping("/helloword")
    public String helloworld() {
        TalkExample example=new TalkExample();
        TalkExample.Criteria criteria = example.createCriteria();
        List<Talk> talks = talkMapper.selectByExample(example);
        String jsonString = JSONArray.toJSONString(talks);
        return jsonString;
    }


}
