package org.algorithm.小沐.中等;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NC137表达式求值 {
    /** 题目
     *  请写一个整数计算器，支持加减乘三种运算和括号。
     *
     * 数据范围：0≤∣s∣≤100，保证计算结果始终在整型范围内
     *
     * 要求：空间复杂度：O(n)，时间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
    }};

    public static void calc(Deque<Integer> num, Deque<Character> ops) {
        if (num.isEmpty() || num.size() < 2 || ops.isEmpty()) {
            return;
        }
        // 取两个数出来计算
        int b = num.pollLast();
        int a = num.pollLast();

        // 取一个符号出来计算
        char op = ops.pollLast();
        int ans;

        switch (op) {
            case '-':
                ans = a - b; break;
            case '+':
                ans = a + b; break;
            case '*':
                ans = a * b; break;
            default:
                ans = 0;
        }

        // 结果再重新存进去
        num.add(ans);
    }

    public static int solve (String s) {
        // write code here
        s = s.replaceAll(" ", "");

        int len = s.length();

        // 存放数字
        Deque<Integer> num = new ArrayDeque<>();
        // 防止第一个为负数
        num.add(0);
        // 存放运算符号
        Deque<Character> ops = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                ops.add(c);
            } else if (c == ')') {

                while (!ops.isEmpty()) {
                    // 如果找到了就不再继续计算了
                    if (ops.peekLast() == '(') {
                        ops.pollLast();
                        break;
                    }
                    calc(num, ops);
                }
            } else if (Character.isDigit(c)) {
                // 存储一个整数
                int sum = 0;
                int j = i;

                // 完整的提取一个整数
                while (j < len && Character.isDigit(s.charAt(j))) {
                    sum = sum * 10 + (s.charAt(j) - '0');
                    j += 1;
                }

                num.add(sum);
                // 指向下一个符号
                i = j - 1;
            } else {
                if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                    // 应对负数, 如: 3+-3, (-3-2)
                    num.add(0);
                }

                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    char pre = ops.peekLast();
                    if (map.get(pre) <= map.get(c)) {
                        break;
                    }
                    // 上一个如果有*就先计算
                    calc(num, ops);
                }
                ops.add(c);
            }
        }

        while (!ops.isEmpty() && ops.peekLast() != '(') {
            // 将剩下的计算处理完
            calc(num, ops);
        }
        return num.peekLast();
    }

    public static void main(String[] args) {
        System.out.println(solve("-2*3+-3"));
    }
}
