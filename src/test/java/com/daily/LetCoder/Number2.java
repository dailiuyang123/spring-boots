package com.daily.LetCoder;

/**
 * Created by json on 2018/8/20.
 * Describe:62. 不同路径
 */
public class Number2 {
    
    
    
    /**
    *
    * 作者  json
    * 时间  2018/8/20 15:08
    * 描述 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

     问总共有多少条不同的路径？
    *
    **/
    public int solution(int width,int high){

        //初始化 二维数组
        int[][] g=new int[width][high];
        //起点
        int temp = g[0][0];
        //终点
        int end=g[width-1][high-1];

        //走右步数
        int right=width-1;
        //走下步数
        int xia=high-1;



        return 0;
    }


    public static void main(String[] args) {



    }
    
}
