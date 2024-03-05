package org.algorithm.小沐.简单;

public class NC55最长公共前缀 {
    /** 题目
     *  给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
     *
     * 数据范围： 0≤n≤5000，0≤len(strs下标i)≤5000
     * 进阶：空间复杂度 O(1)，时间复杂度 O(n∗len)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public static String longestCommonPrefix (String[] strs) {
        // write code here
        int len = strs.length;
        if (len == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {

            // 每个都对比
            for (int j = 1; j < len; j++) {
                if (strs[j].length() == i || strs[0].charAt(i) != strs[j].charAt(i)) {
                    // 如果下面的长度不够 或者 不匹配 就结束
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strArr = new String[] {"abca","abc","abca","abc","abcc"};
        System.out.println(longestCommonPrefix(strArr));
    }
}
