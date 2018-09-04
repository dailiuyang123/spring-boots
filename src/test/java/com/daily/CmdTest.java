package com.daily;

import com.daily.mybatis.entity.Article;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by json on 2018/6/7.
 * Describe: 测试 cmd 指令
 */
public class CmdTest {

    @Test
    public void testCmd(){
        try {
            Process pro = Runtime.getRuntime().exec("cmd /c java -version");
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testStringContent(){
        String name="基金";
        String fullname="基金88";
        int i = fullname.indexOf(name);
        System.out.println(i);
        Class<? extends String> nameClass = name.getClass();
        String s = nameClass.toString();
        Article article=new Article();
        String s1 = article.getClass().toString();
        System.out.println(s);
        System.out.println(s1);
        //Object 通用方法


    }


}
