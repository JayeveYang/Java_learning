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
    public void getNext(String t, int[] next) {
        int i = 0, j = -1;
        next[0] = j;
        while (i < t.length()) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

    }

    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        if (needle.length() > haystack.length()) return -1;
        int[] next = new int[needle.length() + 1];
        getNext(needle, next);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) return i - j;
        else return -1;
    }
}
