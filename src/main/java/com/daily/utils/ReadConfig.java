package com.daily.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String path = ReadConfig.class.getResource("/").getPath() + "PersonConfig.properties";
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties.load(new InputStreamReader(inputStream,"GBK"));
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


}
