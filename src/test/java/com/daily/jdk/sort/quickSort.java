package com.daily.jdk.sort;

import java.util.Scanner;

/**
 * Created by json on 2018/9/26.
 * Describe: 快速排序
 */
public class quickSort {

    /**
     * 作者  json
     * 时间  2018/9/26 16:38
     * 描述 快速排序 ：
     * step 1： 随机在数组内选择一个元素，将数组分为两部分
     * step 2： 将数组内比元素小的放到 元素左边 比元素值大的 放到右边 。
     * step 3： 重复1-2 步 直到不可分为止。
     **/
    public static void QuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left, j = right, key = arr[left];
        while (i < j) {
            while (i < j && key <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && key > arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        QuickSort(arr, left, i - 1);
        QuickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请初始化数组长度：");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("请初始化数组内元素：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
