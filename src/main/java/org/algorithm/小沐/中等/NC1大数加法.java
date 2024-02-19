package org.algorithm.小沐.中等;


public class NC1大数加法 {
    /** 题目
     *  以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
     *
     * 数据范围：s.length,t.length≤100000，字符串仅由'0'~‘9’构成
     * 要求：时间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        // 两个其中有空的就返回另一个
        if (s == null || s.length() == 0) {
            return t;
        }
        if (t == null || t.length() == 0) {
            return s;
        }

        // 假定s是最长的
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        // 存储结果
        char[] sum = new char[s.length()];
        // 存储进位
        int carry = 0;

        // 遍历最长字符串
        for (int i = s.length() - 1; i >= 0; i--) {
            int temp = s.charAt(i) - '0' + carry;

            // 另一个字符串剩余的长度(即index)
            int len = t.length() - (s.length() - i);
            if (len >= 0) {
                temp += t.charAt(len)  - '0';
            }

            carry = temp / 10;
            temp = temp % 10;
            sum[i] = (char) (temp + '0');
        }

        String result = String.valueOf(sum);

        if (carry == 1) {
            result = "1" + result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve("11234", "12345"));
    }
}
