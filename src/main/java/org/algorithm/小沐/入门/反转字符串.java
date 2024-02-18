package org.algorithm.小沐.入门;

public class 反转字符串 {

    /** 题目
     * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     * 数据范围：0 <= n <= 1000
     * 要求：空间复杂度O(n), 时间复杂度O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public static String solve (String str) {
        // write code here
        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left += 1;
            right -= 1;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(solve("12345"));
    }
}
