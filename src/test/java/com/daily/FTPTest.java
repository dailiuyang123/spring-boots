package com.daily;

import com.daily.utils.FTPUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by json on 2018/7/24.
 * Describe:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FTPTest {

    @Test
    public void testFtpDownload() throws UnsupportedEncodingException {
        FTPUtil ftpUtil=new FTPUtil();
        FTPClient ftpClient = ftpUtil.initFTP();
        //
        File file=new File("D:\\组合查询字段.xlsx");
        String fileName="组合查询字段.xlsx";
        String s1 = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        //String s = ftpUtil.encodingPath(fileName);
        try {
            ftpUtil.uploadFile(ftpClient,s1,file);
            ftpUtil.downloadLocal(ftpClient,s1,"D:\\study");
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
