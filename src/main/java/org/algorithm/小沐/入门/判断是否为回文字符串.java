package org.algorithm.小沐.入门;

public class 判断是否为回文字符串 {

    /** 题目
     *  给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
     *  字符串回文指该字符串正序与其逆序逐字符一致。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    /*public static boolean judge (String str) {
        // write code here
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }*/

    public static boolean judge (String str) {
        // write code here

        // 不同的取str方式
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(judge("yamatomaya"));
    }
}
