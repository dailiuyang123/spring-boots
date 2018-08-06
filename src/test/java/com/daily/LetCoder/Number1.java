package com.daily.LetCoder;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by json on 2018/8/6.
 * Describe: 算法部分
 */
public class Number1 {
    /**
    *
    * 作者  json
    * 时间  2018/8/6 10:50
    * 描述 1. 两数之和
    *
     *
     *
    **/
    @Test
    public void test1(){

//        int[] param=new int[100];
//        for (int i : param) {
//            double random = Math.random()*100;
//            Integer integer = Integer.valueOf((int) random);
//            System.out.println(integer);
//            param[i]=integer;
//        }
         int[] param=new int[4];
         param[0]=2;
         param[1]=7;
         param[2]=11;
         param[3]=15;

        System.out.println("----------------------------------------------");
        int[] ints = this.twoSum(param, 9);
        int[] ints2 = this.twoSum2(param, 9);
        for (int anInt : ints) {
            System.out.println(ints[anInt]);
        }

        for (int anInt : ints2) {
            System.out.println(ints2[anInt]);
        }

    }


    /**
    *
    * 作者  json
    * 时间  2018/8/6 10:53
    * 描述 给定 nums = [2, 7, 11, 15], target = 9
     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
    *
    **/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valKey=new HashMap<>();
        Map<Integer,Integer> saveValue=new HashMap<>();
        int[] result = new int[2];
        for (int i= 0;i<nums.length;i++) {
            if (valKey.containsKey(nums[i]) ){
                saveValue.put(nums[i],i);
            }else {
                valKey.put(nums[i], i);
            }
        }
        Set<Integer> integers = valKey.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            Integer tempVal = valKey.get(integer);
            //注意
            iterator.remove();
            if (valKey.containsKey(target-integer)){
                result[0]=tempVal;
                result[1]=valKey.get(target-integer);
            }else if(saveValue.containsKey(target-integer)){
                result[0]=tempVal;
                result[1]=saveValue.get(target-integer);
            }
        }
        return result;
    }

    /**
    *
    * 作者  json
    * 时间  2018/8/6 14:47
    * 描述  最优解 -  一遍哈希表
     * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，
     * 我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
    *
    **/
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
