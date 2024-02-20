package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.Arrays;

public class NC121字符串的排列 {

    /** 题目
     * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
     * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
     * 数据范围：n<10
     * 要求：空间复杂度 O(n!)，时间复杂度 O(n!)
     * 输入描述：
     * 输入一个字符串,长度不超过10,字符只包括大小写字母。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串ArrayList
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        // 转成数组排序: 便于跳过重复组合
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        // 准备基础数据
        boolean[] used = new boolean[str.length()];
        StringBuffer strResult = new StringBuffer();

        recursionPermutation(result, chars, strResult, used);

        return result;
    }
    public static void recursionPermutation(ArrayList<String> result, char[] chars, StringBuffer strResult, boolean[] used) {

        if (strResult.length() == chars.length) {
            // 排列好了就存进去
            result.add(new String(strResult));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                // 存在strResult中的就跳过
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                // 回溯之后, 如果相邻的相同则跳过
                continue;
            }

            // 存到strResult中
            strResult.append(chars[i]);
            used[i] = true;

            // 递归深入
            recursionPermutation(result, chars, strResult, used);

            // 又一个轮回
            used[i] = false;
            // 轮到下一个了
            strResult.deleteCharAt(strResult.length() - 1);
        }
    }


    public static void main(String[] args) {
        Permutation("AAB").forEach(System.out::println);
    }
}
