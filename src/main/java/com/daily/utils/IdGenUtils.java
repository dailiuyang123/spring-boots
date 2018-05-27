package com.daily.utils;

import org.apache.commons.codec.binary.Base64;

import java.util.UUID;

/**
 * Created by Azir on 2018/1/27.
 */
public class IdGenUtils {
    private IdGenUtils(){

    }

    /**
     *
     * @Title: base64UID
     * @Description: 登录返回给前端的token
     * @return
     * @return: String
     */
    public static String base64UID(){
        return Base64.encodeBase64String(UUID.randomUUID().toString().getBytes());
    }

    /**
     * @Title: UUID
     * @Description: UUID得到32位不重复主键
     * @param @return
     * @return String
     * @throws @author
     *             yangdognxu
     * @date 2016年8月17日 下午2:55:04
     */
    public static String UUID() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }





}
