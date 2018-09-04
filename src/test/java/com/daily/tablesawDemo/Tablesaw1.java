package com.daily.tablesawDemo;


import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.columns.Column;
import tech.tablesaw.selection.Selection;

/**
 * Created by json on 2018/8/21.
 * Describe: Tablesaw 测试第一个
 */
public class Tablesaw1 {


    /**
    *
    * 作者  json
    * 时间  2018/8/21 17:26
    * 描述   Tablesaw API 测试
    * Tablesaw 处理是基于列操作的
    **/
    public static void main(String[] args) {
        double[]  doubles={1,2,3};
        // 初始化-tablesaw
        DoubleColumn test = DoubleColumn.create("test", doubles);
        // 打印 一个 column实例
        System.out.println(test.print());
        // 根据从0开始的序列 根据下标获取某个column实例的元素
        Double aDouble = test.get(2);
        System.out.println(aDouble);

        // 对column实例 进行 加、减、乘、除操作
        DoubleColumn multiply = test.multiply(2);
        // 对column实例 修改 column 名
        multiply.setName("test2");
        System.out.println(multiply.print());

        //列 column筛选
        Selection lessThan = multiply.isLessThan(3);
        DoubleColumn where = multiply.where(lessThan);
        System.out.println("筛选 比3小的列："+where.print());

        //

    }


}
