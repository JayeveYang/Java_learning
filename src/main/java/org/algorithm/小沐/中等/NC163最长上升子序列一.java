package org.algorithm.小沐.中等;

import java.util.Arrays;

public class NC163最长上升子序列一 {

    /** 题目
     *  给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
     * 所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列。
     * 我们定义一个序列是 严格上升 的，当且仅当该序列不存在两个下标 i<j 且 arr下标i ≥ arr下标j 数据范围：0≤n≤1000
     * 要求：时间复杂度 O(n^2)， 空间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public static int LIS (int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int[] resultArr = new int[arr.length];
        Arrays.fill(resultArr, 1);
        int sum = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // 找比arr[j]大,且为当前数组中递增最大的
                if (arr[i] > arr[j] && resultArr[i] < resultArr[j] + 1) {
                    resultArr[i] = resultArr[j] + 1;
                    sum = Math.max(resultArr[i], sum);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,6,7};
        System.out.println(LIS(arr));
    }
}
