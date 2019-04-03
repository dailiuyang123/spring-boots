package com.daily;

import org.junit.Test;

/**
 * @ClassName StringAPITest
 * Description: TODO
 * @Author dailiuyang
 * @Date 2019/4/3 14:13
 **/
public class StringAPITest {

    @Test
    public void testsubstrat(){
        String demo="-1000";
        String demo_cn="-1000";

        String substring = demo.substring(0, 1);
        String substring1 = demo_cn.substring(0, 1);
        String substring2 = demo.substring(1);
        System.out.println(substring2);
        if(substring.equals("-")){
            System.out.println(substring+": true en");
        }

        if(substring1.equals("-")){
            System.out.println(substring1+" : true en ");
        }
    }

}
