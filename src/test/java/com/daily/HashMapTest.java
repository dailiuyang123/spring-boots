package com.daily;

import com.daily.utils.ReadConfig;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by json on 2018/6/5.
 * Describe:
 */

public class HashMapTest {

    @Test
    public void testMap(){
        Map map=new HashMap();
        map.put("hello","word");
        map.put("tom","jerry");
        map.put("num",123);
        boolean entrySet = map.entrySet().remove("hello=word");
        System.out.println(entrySet);
        Set entrySet1 = map.entrySet();
        for (Object o : entrySet1) {

            System.out.println(o);
        }

    }


    /**
    *
    * 作者  json
    * 时间  2018/6/5 14:12
    * 描述 正则表达式
    *
    **/
    @Test
    public void testpars(){

        String str = "99";
        String pattern = "-?[1-9]\\d*";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }




}
