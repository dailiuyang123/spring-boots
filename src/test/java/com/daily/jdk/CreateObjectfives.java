package com.daily.jdk;

/**
 * Created by Azir on 2018/9/28.
 */


import java.lang.reflect.Constructor;

/**
 *  Author: 代刘洋
 *  Time：  2018/9/28  21:56
 *  Title: java 创建 对象的5种方法
 *  Param:
 *  Response:
 *
 */
public class CreateObjectfives {


    private  String name;

     public CreateObjectfives(String name) {
         this.name = name;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

    @Override
    public String toString() {
        return "CreateObjectfives{" + "name='" + name + '\'' + '}';
    }

    // java 创建 对象 总共 有 5中方法
     public static void main(String[] args) throws Exception {

         // 通过 “new ” 关键字 创建 对象
         CreateObjectfives createObjectfives1=new CreateObjectfives("new 创建");
         System.out.println(createObjectfives1);
         //通过 class 类的反射机制 创建
         CreateObjectfives o2 =(CreateObjectfives) Class.forName("com.daily.jdk.CreateObjectfives").newInstance();
         System.out.println(o2);

         // 使用Constructor类的newInstance方法
         Constructor<CreateObjectfives> constructor = CreateObjectfives.class.getConstructor();
         CreateObjectfives createObjectfives3 = constructor.newInstance();
         System.out.println(createObjectfives3);
         /// / 使用clone方法
         CreateObjectfives clone =(CreateObjectfives) createObjectfives1.clone();
         System.out.println(clone);
         //使用 反序列化

     }



}
