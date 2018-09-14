package com.daily.jdk;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by json on 2018/9/12.
 * Describe: java 反射 api 测试。
 */
public class JavaReflect {

    public String field;

    private String privatefields;


    @Test
    public void reflectTest() throws ClassNotFoundException {


        //获得 Class 对象
        Class<JavaReflect> javaReflectClass = JavaReflect.class;

        //获取 类的 全路径名
        String name = javaReflectClass.getName();
        System.out.println("类名："+name);
        //获取 类的简称
        String simpleName = javaReflectClass.getSimpleName();
        System.out.println("类名简称："+simpleName);

        //通过 全路径名
        Class<?> aClass = Class.forName(name);

        //判断 类的属性？
        int modifiers = aClass.getModifiers();
        System.out.println(modifiers);
        boolean anAbstract = Modifier.isAbstract(modifiers);
        boolean aPublic = Modifier.isPublic(modifiers);
        System.out.println("是否是抽象类："+anAbstract);
        System.out.println("是否是 public 类："+aPublic);

        //通过 Class 对象你可以访问类的父类
        Class superclass = aClass.getSuperclass();
        String superclassName = superclass.getName();
        System.out.println("父类名："+superclassName);

        //获取指定类所实现的接口集合：
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("该类实现的接口："+anInterface.getName());
        }

        //访问一个类的所有方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("该类的方法："+method.getName());
        }

        //访问一个类的成员变量
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println("该类的公开的属性："+field.getName());
        }

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("该类的所有的属性："+declaredField.getName());
        }
    }


}
