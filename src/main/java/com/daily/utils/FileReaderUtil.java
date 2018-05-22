package com.daily.utils;

import java.io.*;

/**
 * Created by json on 2018/5/21.
 * Describe: 文件读取工具类
 */
public class FileReaderUtil {


    // 通过字节流读取文件(Java 7的TWR自己会对文件流进行关闭)
    public static void readByInputStream(String path)
            throws FileNotFoundException, IOException {
        try (FileInputStream is = new FileInputStream(path)) {
            int n = 4096;
            byte[] buffer = new byte[n];
            while ((is.read(buffer, 0, n)) != -1) {
                System.out.println(new String(buffer, "UTF-8"));
            }
        }
    }

    // 通过字符流读取文件
    // FileReader可以读取单个字符或者是根据指定位置开始的固定长度的字符,没有可以直接获取一行的方法,FileReader继承了InputStreamReader，但并没有实现父类中带字符集参数的构造函数，所以FileReader只能按系统默认的字符集来解码，然后在UTF-8 -> GBK ->UTF-8的过程中编码出现损失，造成结果不能还原最初的字符。
    public static void readByReader(String path) throws FileNotFoundException,
            IOException {
        // 会出现部分中文乱码
        // try(BufferedReader br = new BufferedReader(new FileReader(path))){
        // String str = null;
        // while(null != (str = br.readLine())){
        // System.out.println(new String(str.getBytes("GBK"),"UTF-8"));
        // }
        // }

        // 直接使用InputStreamReader进行编码设置
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), "UTF-8"))) {
            String str = null;
            while (null != (str = br.readLine())) {
                System.out.println(str);

            }
        }
    }


}
