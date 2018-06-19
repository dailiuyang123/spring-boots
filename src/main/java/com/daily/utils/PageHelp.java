package com.daily.utils;

/**
 * Created by json on 2018/6/19.
 * Describe: 分页工具类
 */
public class PageHelp {

    //返回起始边界值
    public static  Integer  getStart(int page,int size) throws Exception {
       if (page==1){
           return 1;
       }else if (page<1){
           throw new Exception("页码错误");
       }else {
           return (page-1)*size+1;
       }

    }


    //获取总页数
    public static Integer getTotal(int total,int size){
        if (total==0){
            return 0;
        }
        if (total%size==0){
            return total/size;
        }else {
            return total/size+1;
        }
    }
}
