package com.daily.service;

import com.daily.annotation.RedisCache;
import com.daily.mybatis.dao.TalkMapper;
import com.daily.mybatis.entity.Talk;
import com.daily.mybatis.entity.TalkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by json on 2018/5/24.
 * Describe:
 */
@Service
@Transactional
public class TalkService {

    @Autowired
    private TalkMapper talkMapper;

    @RedisCache
    public List<Talk> selectAll(){

        TalkExample example=new TalkExample();
        TalkExample.Criteria criteria = example.createCriteria();
        List<Talk> talks = talkMapper.selectByExample(example);
        return talks;
    }

}
