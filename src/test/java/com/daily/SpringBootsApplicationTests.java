package com.daily;

import com.alibaba.fastjson.JSONArray;
import com.daily.config.RabbitTask.Sender;
import com.daily.mybatis.dao.TalkMapper;
import com.daily.mybatis.entity.Talk;
import com.daily.mybatis.entity.TalkExample;
import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootsApplicationTests {

	@Autowired
	private TalkMapper talkMapper;

	@Test
	public void contextLoads() {
		TalkExample example=new TalkExample();
		TalkExample.Criteria criteria = example.createCriteria();
		List<Talk> talks = talkMapper.selectByExample(example);
		String jsonString = JSONArray.toJSONString(talks);
		Talk talk=new Talk();
		talk.setId(UUID.randomUUID().toString());
		talk.setContent("评论一哈，666");
		talk.setTitle("jjjj");
		talkMapper.insertSelective(talk);
		System.out.println(jsonString);

	}

	
	/**
	*
	* 作者  json
	* 时间  2018/5/8 17:13
	* 描述 测试MQ 
	*
	**/
//	@Test
//	public void hello() throws Exception {
//		sender.send();
//	}

}
