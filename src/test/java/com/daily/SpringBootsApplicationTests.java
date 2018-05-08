package com.daily;

import com.alibaba.fastjson.JSONArray;
import com.daily.config.RabbitTask.Sender;
import com.daily.mybatis.dao.TalkMapper;
import com.daily.mybatis.entity.Talk;
import com.daily.mybatis.entity.TalkExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootsApplicationTests {

	@Autowired
	private TalkMapper talkMapper;
	@Autowired
	private Sender sender;
	@Test
	public void contextLoads() {
		TalkExample example=new TalkExample();
		TalkExample.Criteria criteria = example.createCriteria();
		List<Talk> talks = talkMapper.selectByExample(example);
		String jsonString = JSONArray.toJSONString(talks);
		System.out.println(jsonString);

	}

	
	/**
	*
	* 作者  json
	* 时间  2018/5/8 17:13
	* 描述 测试MQ 
	*
	**/
	@Test
	public void hello() throws Exception {
		sender.send();
	}

}
