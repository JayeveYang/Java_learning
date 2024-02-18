package org.algorithm.小沐.较难;

import java.util.Stack;

public class NC49最长的括号子串 {
    /** 题目
     *  给出一个长度为 n 的，仅包含字符 '(' 和 ')' 的字符串，计算最长的格式正确的括号子串的长度。
     *
     * 例1: 对于字符串 "(()" 来说，最长的格式正确的子串是 "()" ，长度为 2 .
     * 例2：对于字符串 ")()())" , 来说, 最长的格式正确的子串是 "()()" ，长度为 4 .
     *
     * 字符串长度：0 ≤ n ≤ 5∗10^5
     * 要求时间复杂度 O(n) ,空间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型
     */
    /** 栈: 遇到合适的就私奔, 并记录长度(减单身狗) */
    public static int longestValidParentheses (String s) {
        // 记录私奔个数
        int longest = 0;
        // 记录没有进入市场的单身狗索引
        int index = -1;
        // 构建相亲市场
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 单身进入市场
                stack.push(i);
            } else if (stack.isEmpty()) {
                // 没有单身的就不进入市场,但任然是单身
                index = i;
            } else {
                // 有单身, 一起私奔
                stack.pop();
                // 市场还有单身狗就看市场, 没有就看市场外的
                longest = Math.max(longest, stack.isEmpty() ? i - index: i - stack.peek());
            }
        }
        return longest;
    }



    /** 动态规划: 记录上一个的动态信息 */
    public static int longestValidParentheses1 (String s) {
        // write code here
        // 记录合法数据数量
        int longest = 0;
        if(s == null || s.length() == 0) {
            return longest;
        }

        // 记录长度(初始化全部都是0)
        int[] strLen = new int[s.length()];

        // 从1开始, 0不考虑
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            // 有两种合法场景: 挨着和隔着
            // 场景一: 两个括号挨着
            if (s.charAt(i-1) == '(') {
                // 记录合法长度: 上一个 + 这次
                strLen[i] = (i >= 2 ? strLen[i - 2] : 0) + 2;
            } else if (i - strLen[i - 1] - 1 >= 0 && s.charAt(i - strLen[i - 1] - 1) == '(') {
                // 场景二: 两个括号隔着
                // 记录合法长度:上上一个 + 上一个 + 这次
                strLen[i] = (i - strLen[i - 1] >= 2 ? strLen[i - strLen[i - 1] - 2] : 0 ) + strLen[i - 1] + 2;
            }
            longest = Math.max(longest, strLen[i]);
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()(()()((((((())("));
    }
}
