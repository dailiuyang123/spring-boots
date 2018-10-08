package com.daily;

import com.daily.common.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Azir on 2018/10/8. 测试邮件工具类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {


    @Autowired
    private MailServiceImpl MailService;

    @Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("dailiuyangchina@gmail.com","test simple mail"," hello this is simple mail");
    }

}
