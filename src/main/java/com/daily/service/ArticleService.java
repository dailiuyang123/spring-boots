package com.daily.service;

import com.daily.mybatis.dao.ArticleMapper;
import com.daily.mybatis.entity.Article;
import com.daily.mybatis.entity.ArticleExample;
import com.daily.mybatis.entity.ArticleWithBLOBs;
import com.daily.utils.IdGenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Azir on 2018/5/27.
 */
@Transactional
@Service
public class ArticleService {

@Autowired
    private ArticleMapper articleMapper;


   public void  createArticle(Map param){

       ArticleWithBLOBs articleWithBLOBs=new ArticleWithBLOBs();
       articleWithBLOBs.setArticelTitle(param.get("title").toString());
       articleWithBLOBs.setArticelContent(param.get("content").toString());
       articleWithBLOBs.setPublishTime(new Date());
       articleWithBLOBs.setArticleId(IdGenUtils.UUID());
    articleMapper.insertSelective(articleWithBLOBs);

   }


   public Map selectArticles(Map param){

       ArticleExample articleExample=new ArticleExample();
       ArticleExample.Criteria criteria = articleExample.createCriteria();
       if(!StringUtils.isEmpty(param.get("userId"))){
            criteria.andUserIdEqualTo(param.get("userId").toString());
       }
       List<ArticleWithBLOBs> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
       Map result=new HashMap();
       result.put("data",articles);
       return result;
   }

   public Map selectArticleById(Map param) throws Exception {
       Map result=new HashMap();
       if (StringUtils.isEmpty(param.get("id")) ){
          throw new Exception("id 不能为空");
       }else {
           String id = param.get("id").toString();
           ArticleWithBLOBs articleWithBLOBs = articleMapper.selectByPrimaryKey(id);
           result.put("data",articleWithBLOBs);
       }
       return result;
   }



}
