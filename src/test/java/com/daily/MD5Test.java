package com.daily;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 17600 on 2019/12/15.
 */
public class MD5Test {


    /**
     * 获取 文件 MD5
     */
    public static void main(String[] args) throws IOException {

        String path="D:\\1.txt";
        String path2="D:\\2.txt";
        String path3="D:\\1.1.txt";

        FileInputStream fis= new FileInputStream(path);
        String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
        IOUtils.closeQuietly(fis);
        System.out.println("p1_MD5:"+md5);

        FileInputStream fis2= new FileInputStream(path2);
        String md52 = DigestUtils.md5Hex(IOUtils.toByteArray(fis2));
        IOUtils.closeQuietly(fis2);
        System.out.println("p2_MD5:"+md52);

        FileInputStream fis3= new FileInputStream(path3);
        String md53 = DigestUtils.md5Hex(IOUtils.toByteArray(fis3));
        IOUtils.closeQuietly(fis2);
        System.out.println("p3_MD5:"+md53);


    }



}
