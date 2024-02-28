package org.algorithm.小沐.中等;

public class NC91最长上升子序列三 {
    /** 题目
     *  给定数组 arr ，设长度为 n ，输出 arr 的最长上升子序列。（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
     *
     * 数据范围：0≤n≤200000,0≤arr下标i≤1000000000
     * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
     *
     * 注意: [1,2,8,6,4]其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个 按数值进行比较的字典序 最小，故答案为（1，2，4）
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS(int[] arr) {
        int arrLen = arr.length;
        if (arrLen == 0) {
            return new int[] {};
        }
        // 存放可能作为子序列的末尾最小值(遇到不能放在末尾的就替换最近的较大值, 下标作为长度)
        int[] dp = new int[arrLen + 1];
        // 记录遍历数值可以组合成合规序列的长度1v1
        int[] p = new int[arrLen + 1];

        // 默认长度为1
        int len = 1;
        dp[len] = arr[0];
        p[0] = len;

        for (int i = 1; i < arrLen; i++) {
            // 可以放在末尾的就放在末尾(证明是合规的)
            if (arr[i] > dp[len]) {
                len += 1;
                dp[len] = arr[i];
                p[i] = len;
            } else {
                // 二分法查找-最近的较大值
                int start = 1;
                int end = len;

                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (dp[mid] < arr[i]) {
                        // 大于就在右边
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                // 不小于的索引, 然后替换
                dp[start] = arr[i];
                p[i] = start;
            }
        }

        int[] result = new int[len];
        for (int i = arrLen - 1; i >= 0; i--) {
            if (p[i] == len) {
                // 递减取长度
                len -= 1;
                result[len] = arr[i];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] lis = LIS(arr);

        for (int i: lis) {
            System.out.println(i);
        }
    }
}
