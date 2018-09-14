package com.daily;

import com.daily.mybatis.entity.Talk;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by json on 2018/7/11.
 * Describe: jdk 1.8 Stream初体验
 */
public class StreamTest {

    //Stream是元素的集合，这点让Stream看起来用些类似Iterator；
    //可以支持顺序和并行的对原Stream进行汇聚的操作；
    @Test
    public void teststream(){
        List<Integer> nums= Lists.newArrayList(1,3,null,5);
        Long nu= nums.stream().filter(num->num!=null).count();
        System.out.println("测试不是null元素的次数："+nu);

        Class<StreamTest> streamTestClass = StreamTest.class;
        String name = streamTestClass.getName();

        System.out.println(name);

        //
        Talk talk=new Talk();
        talk.setCreateTime(new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        talk.setUpdateTime(new Date());
        talk.setStar(3);
        List<Talk> talks=new ArrayList<>();
        Talk talk1=new Talk();
        talk1.setCreateTime(new Date());
        talk1.setUpdateTime(new Date());
        talk1.setStar(2);
        Talk talk2=new Talk();
        talk2.setStar(2);
        talks.add(talk);
        talks.add(talk1);
        talks.add(talk2);
       // List<Talk> talks1=talks.stream().filter(o->{return !o.getCreateTime().equals(o.getUpdateTime()) ;}).collect(Collectors.toList());

        //聚合操作
        //按star数 排序 从小到大
        //排序 用 stream.sorted()方法
        List<Talk> talks2 = talks.stream().sorted((x, y) -> {return x.getStar() > y.getStar() ? 1 : -1;}).collect(Collectors.toList());
        talks2.forEach(o->{
            System.out.println(o);
        });

        //获取 star数 为 2
        // 用 stream.filter() 方法
        List<Talk> talks3= talks.stream().filter(o->{return o.getStar()==2;}).collect(Collectors.toList());
        talks3.forEach(o->{
            System.out.println(o);
        });

//        System.out.println(talks1);
    }


}
