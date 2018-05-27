package com.daily.service;

import com.daily.mybatis.dao.ArticleMapper;
import com.daily.mybatis.entity.ArticleWithBLOBs;
import com.daily.utils.IdGenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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


}
