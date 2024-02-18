package org.algorithm.小沐.入门;

import java.util.Objects;

public class 斐波那契数列 {

    /** 题目
     *  大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
     *  要求：空间复杂度 O(1)，时间复杂度O(n) ，本题也有时间复杂度 O(logn) 的解法
     *  根据斐波那契数列的定义可知，fib(1)=1,fib(2)=1,fib(3)=fib(3-1)+fib(3-2)=2,fib(4)=fib(4-1)+fib(4-2)=3
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */

    /*public static int Fibonacci (int n) {
        // write code here
        if (n < 3) {
            return Objects.equals(n, 0) ? 0 : 1;
        }
        // 数组的形式存
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }*/

    public static int Fibonacci (int n) {
        // write code here
        if (n < 3) {
            return Objects.equals(n, 0) ? 0 : 1;
        }

        // 不存数据，只返回最终结果
        int pre = 1;
        int sum = 0;
        int temp = 1;
        for (int i = 3; i <= n; i++) {
            sum = pre + temp;
            temp = pre;
            pre = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(6));
    }
}
