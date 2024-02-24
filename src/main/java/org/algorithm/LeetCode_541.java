package org.algorithm;

public class LeetCode_541 {
    /*
     * 题目
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * */
    public String reversePartStr(String s, int start, int end) {
        char[] sArray = s.toCharArray();
        while (start < end) {
            char temp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = temp;
            start++;
            end--;
        }
        return new String(sArray);
    }

    public String reverseStr(String s, int k) {
        int i, j = 0;
        for (i = 0; i < s.length() / (2 * k); i++) {
            s = reversePartStr(s, j, j + k - 1);
            j += 2 * k;
        }
        if (s.length() % (2 * k) >= k) {
            s = reversePartStr(s, j, j + k - 1);
        } else {
            s = reversePartStr(s, j, s.length() - 1);
        }
        return s;
    }
}
