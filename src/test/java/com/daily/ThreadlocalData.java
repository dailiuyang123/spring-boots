package com.daily;

/**
 * Created by json on 2018/8/7.
 * Describe:
 */
public class ThreadlocalData {

    public static ThreadLocal<String> value=new ThreadLocal<>();

    public static String getValue() {
        String value = ThreadlocalData.value.get();
        return value;
    }

    public static void setValue(String value) {

        ThreadlocalData.value.set(value);
    }
}
