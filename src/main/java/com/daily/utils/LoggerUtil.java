package com.daily.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by json on 2018/5/22.
 * Describe:
 */
public class LoggerUtil {

    public static final String LOG_TARGET_TYPE="targetType";
    public static final String LOG_ACTION="action";
    public static final String LOG_REMARK="remark";
    public LoggerUtil(){}


    /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }


}
