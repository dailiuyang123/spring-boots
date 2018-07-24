package com.daily.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by json on 2018/7/24.
 * Describe: FTP 服务器工具类
 */
@Component
public class FTPUtil {

    @Value("${ftp.host}")
    private String host;

    @Value("${ftp.username}")
    private String username;

    @Value("${ftp.password}")
    private String password;

    @Value("${ftp.path}")
    private String path;

    @Value("${spring.redis.host}")
    private String host1;

    Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    @Bean
    public FTPClient initFTP() {
        FTPClient ftp = new FTPClient();
        try {
            //链接ftp
            ftp.connect("172.16.2.234", 21);
            //登录 ftp
            ftp.login("ftptest", "paw123###");
            //获取响应吗
            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                logger.error("FTP is disconnect !");
                ftp.disconnect();
            }
            //转移到 ftp 目录
            ftp.changeWorkingDirectory("/home/ftptest");
            FTPFile[] fs = ftp.listFiles("sql.txt");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("ftp connect is fail ! ");
        }
        return ftp;
    }


    /**
     * 编码文件路径
     */
    public String encodingPath(String path) throws UnsupportedEncodingException {
        // FTP协议里面，规定文件名编码为iso-8859-1，所以目录名或文件名需要转码
        return new String(path.replaceAll("//", "/").getBytes("UTF-8"), "iso-8859-1");
    }


    /**
     * 作者  json
     * 时间  2018/7/24 14:38
     * 描述 丛ftp服务器下载文件到本地
     *
     * @Param FTPClient ftp 获得ftpclient链接对象
     * @Param String fileName 要下载的文件名
     * @Param String localPath 要下载到本地的路径
     **/
    public void downloadLocal(FTPClient ftp, String fileName, String localPath) throws Exception {
        FTPFile[] ftpFiles1 = ftp.listFiles();
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        FTPFile[] ftpFiles = ftp.listFiles(fileName);
        if (ftpFiles.length == 0) {
            throw new Exception("下载的文件不存在。");
        }

        String realFileName=new String(fileName.getBytes("iso-8859-1"), "UTF-8");
        File localFile = new File(localPath + "/" + realFileName);
        OutputStream is = new FileOutputStream(localFile);

        ftp.retrieveFile(fileName, is);
        is.close();
    }

    /**
    *
    * 作者  json
    * 时间  2018/7/24 15:03
    * 描述 文件上传
    *
    **/
    public boolean uploadFile(FTPClient ftp,String fileName,File file) throws IOException {
        FileInputStream inputStream =new FileInputStream(file);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        //设置文件编码格式
        ftp.setControlEncoding("UTF-8");
        //保存文件 到ftp
        ftp.storeFile(fileName, inputStream);
        return true;
    }



}
