package com.daily;

import com.alibaba.fastjson.JSONArray;
import com.daily.config.RabbitTask.Sender;
import com.daily.mybatis.dao.ArticleMapper;
import com.daily.mybatis.dao.TalkMapper;
import com.daily.mybatis.entity.Article;
import com.daily.mybatis.entity.ArticleExample;
import com.daily.mybatis.entity.Talk;
import com.daily.mybatis.entity.TalkExample;
import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootsApplicationTests {

	@Autowired
	private TalkMapper talkMapper;

	@Autowired
	private ArticleMapper articleMapper;

	@Test
	public void contextLoads() {
		ArticleExample articleExample=new ArticleExample();
		ArticleExample.Criteria criteria = articleExample.createCriteria();
		List<Article> articles = articleMapper.selectByExample(articleExample);
		String jsonString = JSONArray.toJSONString(articles);
		List<Map> list = JSONArray.parseArray(jsonString, Map.class);

		for (Article article : articles) {
			System.out.println(article.toString());
		}
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
