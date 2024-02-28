package org.algorithm.小沐.较难;

public class NC164最长上升子序列二 {

    /** 题目
     *  给定一个长度为 n 的数组a，求它的最长严格上升子序列的长度。
     * 所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列。
     * 我们定义一个序列是 严格上升 的，当且仅当该序列不存在两个下标
     * i 和j 满足i<j 且a下标i≥a下标j数据范围：0≤n≤10^5, -10^9<=a[i]<=10^9
     * 要求：时间复杂度 O(nlogn)， 空间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 该数组最长严格上升子序列的长度
     * @param a int整型一维数组 给定的数组
     * @return int整型
     */
    public static int LIS (int[] a) {
        // write code here
        int arrLen = a.length;
        if (arrLen == 0) {
            return 0;
        }

        // 记录合规的序列, 如果有更合适的就替换掉
        int[] dp = new int[arrLen + 1];
        int len = 1;
        dp[len] = a[0];

        for (int i = 1; i < arrLen; i++) {
            if (dp[len] < a[i]) {
                len += 1;
                dp[len] = a[i];
            } else {
                int start = 1;
                int end = len;
                int mid;

                // dp[]中有合适的就替换掉
                while (start < end) {
                    mid = start + (end - start) / 2;
                    if (dp[mid] < a[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                dp[start] = a[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,1,5,7,2,3,4};
        System.out.println(LIS(arr));
    }
}
