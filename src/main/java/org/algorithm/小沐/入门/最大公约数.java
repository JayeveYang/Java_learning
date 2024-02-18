package org.algorithm.小沐.入门;

public class 最大公约数 {
    /** 题目
     *  如果有一个自然数 a 能被自然数 b 整除，则称 a 为 b 的倍数， b 为 a 的约数。几个自然数公有的约数，叫做这几个自然数的公约数。公约数中最大的一个公约数，称为这几个自然数的最大公约数。
     *  输入 a 和 b , 请返回 a 和 b 的最大公约数。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求出a、b的最大公约数。
     * @param a int整型
     * @param b int整型
     * @return int整型
     */
    /*public static int gcd (int a, int b) {
        // write code here
        // 暴力输出
        int result = Math.min(a, b);
        while (a % result != 0 || b % result != 0) {
            result -= 1;
        }
        return result;
    }*/

    public static int gcd (int a, int b) {
        // write code here
        // 欧几里得算法又称辗转相除法
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println(gcd(615, 1997));
    }
}
