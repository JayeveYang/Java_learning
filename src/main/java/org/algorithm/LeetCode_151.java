package org.algorithm;

public class LeetCode_151 {
    /*
     * 题目
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * */
    public String reverseWords(String s) {
        //删除前导空格、尾随空格或者单词间的多个空格
        StringBuilder sb = removeSpace(s);
        //反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        //反转每个单词
        int pre = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                reverseString(sb, pre, i - 1);
                pre = i + 1;
            }
        }
        //处理最后一个单词
        reverseString(sb, pre, sb.length() - 1);
        return sb.toString();

    }

    public StringBuilder removeSpace(String s) {
        StringBuilder res = new StringBuilder();
        int start = 0, end = s.length() - 1;
        //删除前导空格、尾随空格
        while (s.charAt(start) == ' ' && start < end) start++;
        while (s.charAt(end) == ' ' && start < end) end--;

        //删除单词间的多个空格
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            //当前字符不是空格时，加入字符串
            //如果当前字符是空格，但是字符串尾不是空格时，也可加入字符串
            if (c != ' ' || res.charAt(res.length() - 1) != ' ') {
                res.append(c);
            }
        }
        return res;
    }

    public void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
