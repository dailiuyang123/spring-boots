package com.daily.annotation;

/**
 * Created by json on 2018/5/24.
 * Describe:
 */

import java.lang.annotation.*;

/**
 * 元注解 用来标识查询数据库的方法
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {
}
