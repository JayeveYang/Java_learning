package org.algorithm;

public class LeetCode_28 {
    /*
     * 题目
     * 给你两个字符串 haystack 和 needle ，
     * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     * */
    /*
     * 思路
     * KMP算法
     *
     * */
    //获得下一个位置的数组
    private void getNext(int[] next, String s) {
        // j代表的是当前匹配的字符，同时也是当前公共前后缀长度
        int j = 0;
        //初始化next[]
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            // 当j>0时不匹配，j回到前一项的公共前后缀重复值的后一项
            // j一直回退到j==0或者i和j匹配的情况
            // j==0在边界，j不能回退了
            while (j > 0 && s.charAt(j) != s.charAt(i))
                //不匹配，j回到前一项的公共前后缀重复值的后一项
                // 下一次就直接可以跳过重复部分比较
                j = next[j - 1];
            // 上层循环结束，i和j匹配
            if (s.charAt(j) == s.charAt(i))
                j++;
            // 更新当前i的next数组
            next[i] = j;
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // j>0时出现不匹配情况就一直回退
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                // 不匹配，j回到前一项的公共前后缀重复值的后一项
                j = next[j - 1];
            // 出现匹配
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            // j都匹配
            if (j == needle.length())
                // 求出第一次出现的下标
                return i - needle.length() + 1;
        }
        return -1;

    }
}
