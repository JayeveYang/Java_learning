package org.algorithm.小沐.中等;

import java.util.ArrayList;

public class NC119最小的K个数 {
    /**
     * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
     * 数据范围：0 ≤ k,n ≤ 10000，数组中每个数的大小0 ≤ val ≤1 000
     * 要求：空间复杂度 O(n) ，时间复杂度 O(nlogk)
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param input int整型一维数组
     * @param k int整型
     * @return int整型ArrayList
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        // write code here
        int len = input.length;
        k = Math.min(k, len);

        mergeSort(input, 0, len - 1, new int[len]);
//        quickSort(input, 0, len - 1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /** 归并排序：拆分到最多2个的时候，开始排序，并借用空间来存储排序好的数据，事后则覆盖原先的数据，依次递归操作进行 */
    private static void mergeSort(int[] input, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        // 中间数（向下取整）
        int middle = (start + end) / 2;

        // 对半分，直至最多2个
        mergeSort(input, start, middle, temp);
        mergeSort(input, middle + 1, end, temp);

        // 分完就来排队
        merge(input, start, middle, end, temp);
    }

    private static void merge(int[] input, int start, int middle, int end, int[] temp) {

        // 排队数量
        int num = end - start + 1;
        // 中间数做区分
        int middleIndex = middle++;
        int tempIndex = start;

        // 找小的，小的都放左边
        while (start <= middleIndex && middle <= end) {
            temp[tempIndex++] = input[start] < input[middle] ? input[start++] : input[middle++];
        }

        // 左边剩下的原样排进去
        while (start <= middleIndex) {
            temp[tempIndex++] = input[start++];
        }

        // 右边剩下的原样排进去
        while (middle <= end) {
            temp[tempIndex++] = input[middle++];
        }

        // 狸猫换太子
        for (int i = 0; i < num; i++) {
            input[end] = temp[end--];
        }

    }

    /** 快速排序：取第一个值n，然后双指针进行比较，小于n的方左边，大于n的放右边，直到没得找了，此时指针汇聚时确定n的位置，然后依次递归 */
    private static void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        // 选一个正主出来
        int pivot = input[start];

        int left = start;
        int right = end;
        while (left < right) {
            // 找小的
            while (input[right] > pivot && left < right) {
                right -= 1;
            }
            // 小的放左边
            input[left] = input[right];

            // 有了小的就找大的
            while (input[left] < pivot && left < right) {
                left += 1;
            }
            // 大的放右边
            input[right] = input[left];
        }

        // 正主归位
        input[left] = pivot;

        // 接着找
        quickSort(input, start, left - 1);
        quickSort(input, right + 1, end);
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(input, 4).forEach(System.out::println);
    }
}
