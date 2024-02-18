package org.algorithm.小沐.中等;

public class NC88寻找第K大 {

    /** 题目
     *  有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
     *
     * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
     * 要求：时间复杂度 O(nlogn)，空间复杂度 O(1)
     * 数据范围： 0≤n≤1000, 1≤K≤n，数组中每个元素满足0≤val≤10000000
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型一维数组
     * @param n int整型
     * @param K int整型
     * @return int整型
     */
    public static int findKth (int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n-1, K - 1);
        return a[K-1];
    }


    private static void quickSort(int[] a, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int leftIndex = left;
        int rightIndex = right;
        int pivot = a[left];

        while (left < right) {
            // 先找大的
            while (a[right] <= pivot && left < right) {
                right -= 1;
            }
            a[left] = a[right];

            while (a[left] >= pivot && left < right) {
                left += 1;
            }
            a[right] = a[left];
        }

        a[left] = pivot;

        // 想要的位置已经排序完成
        if (left == k) {
            return;
        }

        // 大小已经有一定的范围了，只需要注意大的范围就好，如果范围满足不了k，那就继续扩大范围
        if (left > k) {
            quickSort(a, leftIndex, left - 1, k);
        } else {
            quickSort(a, left + 1, rightIndex, k);
        }
    }


    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        System.out.println(findKth(a, a.length, 2));
    }
}
