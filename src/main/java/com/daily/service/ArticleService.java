package com.daily.service;

import com.daily.mybatis.dao.ArticleMapper;
import com.daily.mybatis.dao.ArticleTagMapper;
import com.daily.mybatis.dao.TagMapper;
import com.daily.mybatis.entity.*;
import com.daily.utils.IdGenUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Azir on 2018/5/27.
 */
@Transactional
@Service
public class ArticleService {

@Autowired
    private ArticleMapper articleMapper;

@Autowired
    private TagMapper tagMapper;

@Autowired
    private ArticleTagMapper articleTagMapper;


   public void  createArticle(Map param){

       ArticleWithBLOBs articleWithBLOBs=new ArticleWithBLOBs();
       articleWithBLOBs.setArticelTitle(param.get("title").toString());
       articleWithBLOBs.setArticelContent(param.get("content").toString());
       articleWithBLOBs.setPublishTime(new Date());
       articleWithBLOBs.setArticleId(IdGenUtils.UUID());
       //Html 文件处理
       String src = getImageUrl(param.get("content").toString());
       articleWithBLOBs.setTitle_pictrues(src);
       //标签 处理
       if (!StringUtils.isEmpty(param.get("tag"))){
           TagExample tagExample=new TagExample();

           TagExample.Criteria criteria = tagExample.createCriteria();
           criteria.andNameEqualTo(param.get("tag").toString());
           List<Tag> tags = tagMapper.selectByExample(tagExample);
           if (tags.size()==0){
               Tag tag=new Tag();
               tag.setId(IdGenUtils.UUID());
               tag.setName(param.get("tag").toString());
               tag.setCreate_time(new Date());
               tagMapper.insertSelective(tag);
                ArticleTag articleTag=new ArticleTag();
                articleTag.setArticle_id(articleWithBLOBs.getArticleId());
                articleTag.setTag_id(tag.getId());
                articleTagMapper.insertSelective(articleTag);
           }
       }

    articleMapper.insertSelective(articleWithBLOBs);

   }


   public Map selectArticles(Map param){

       ArticleExample articleExample=new ArticleExample();
       articleExample.setOrderByClause("orderByClause DESC");
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


   /**
   *
   * 作者  json
   * 时间  2018/6/12 14:27
   * 描述 删除 文章
   *
   **/
   public void deleteArticle(Map param){
       if (param.containsKey("id")){
           String id = param.get("id").toString();
           articleMapper.deleteByPrimaryKey(id);
       }
   }


   /**
   *
   * 作者  json
   * 时间  2018/6/12 16:12
   * 描述  对Html文本处理获取 image 元素
   *
   **/
   public static String getImageUrl(String content){
       //将 string 转化为 jsoup 的Document对象
       Document document = Jsoup.parse(content);
       Elements imgs = document.getElementsByTag("img");
       String src="";
       if (imgs.size()>0){
           Element element = imgs.get(0);
           Attributes attributes = element.attributes();
           for (Attribute attribute : attributes) {
               String key = attribute.getKey();
               if (key.equals("src")){
                   String value = attribute.getValue();
                   System.out.println("src:"+value);
                   src=value;
                   break;
               }
           }
       }
       return src;
   }




}
