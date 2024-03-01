package org.algorithm;

public class LeetCode_459 {
    /*题目
    * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    * */
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }
        // 关键句
        if (next[s.length() - 1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0)
            return true;
        else
            return false;
    }
}
