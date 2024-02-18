package org.algorithm.小沐.中等;

public class NC17最长回文子串 {

    /** 题目
     * 对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。
     * 数据范围：1 ≤ n ≤ 1000
     * 要求：空间复杂度 O(1)，时间复杂度 O(n^2)
     * 进阶:  空间复杂度 O(n)，时间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A string字符串
     * @return int整型
     */

    /** 方法一：中心扩展法（推荐使用） */
    public static int getLongestPalindrome (String A) {
        // write code here
        int maxLen = 1;
        for (int i = 0; i < A.length() - 1; i++) {
            // 奇数和偶数长度扩散
            maxLen = Math.max(maxLen, Math.max(fun(A, i, i), fun(A, i, i + 1)));
        }
        return maxLen;
    }

    private static int fun(String str, int left, int right) {

        // 相等就扩散开
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left -= 1;
            right += 1;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "abababab";
        System.out.println(getLongestPalindrome(str));
    }
}
