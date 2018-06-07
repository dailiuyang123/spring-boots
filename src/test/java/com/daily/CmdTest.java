package com.daily;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


}
