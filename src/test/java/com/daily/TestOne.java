package com.daily;

import com.daily.utils.RemoteApiInvoke;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

/**
 * Created by json on 2018/5/16.
 * Describe:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOne {

    @Test
    public void  test() throws IOException {

        RemoteApiInvoke remoteApiInvoke=new RemoteApiInvoke();
        Map map = remoteApiInvoke.invokeRemoteApi();
    }
    
    /**
    *
    * 作者  json
    * 时间  2018/5/24 10:22
    * 描述 二叉树 遍历
    *
    **/
    @Test
    public void testTree(){

        
    }
    
}
