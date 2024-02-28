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
    public void getNext(char[] t, int[] next) {
        int i = 0, j = -1;
        next[0] = j;
        while (i < t.length) {
            if (j == -1 || t[i] == t[j]) {
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
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int[] next = new int[needle.length() + 1];
        getNext(t, next);
        while (i < s.length && j < t.length) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length) return i - t.length;
        else return -1;
    }
}
