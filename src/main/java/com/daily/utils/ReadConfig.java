package com.daily.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by json on 2018/6/5.
 * Describe: 读取配置文件
 */
public class ReadConfig {


    /**
     * 作者  json
     * 时间  2018/6/5 15:20
     * 描述  读取配置文件
     **/

    public static Map<String, String> readValue() {
        Map map = new HashMap();
        //传统方法
        String path = ReadConfig.class.getResource("/").getPath() + "PersonConfig.properties";


        String resource = ReadConfig.class.getClassLoader().getResource("PersonConfig.properties").getPath();
        Properties properties = new Properties();

        try {

           // FileInputStream inputStream = new FileInputStream(resource);
            ReadConfig readConfig=new ReadConfig();
            InputStream read = readConfig.read();
            properties.load(new InputStreamReader(read,"GBK"));
            Enumeration<?> enumeration = properties.propertyNames();
            for (Object o : properties.keySet()) {
                map.put(o, properties.getProperty(o.toString()));
                System.out.println(properties.getProperty(o.toString()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    
    //项目以jar包运行时，加载配置文件 读取不到的问题
    public InputStream read(){
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/PersonConfig.properties");
        return resourceAsStream;
    }


}
