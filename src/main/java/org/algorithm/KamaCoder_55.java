//https://kamacoder.com/problempage.php?pid=1065
package org.algorithm;

import java.util.Scanner;

public class KamaCoder_55 {
    /*
     * 题目
     * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
     * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
     * */
    /*
     * 思路
     * 要想不利用其他空间实现右旋，可以通过多次反转来实现。
     * 1.反转整个字符串
     * 2.反转左侧2个字符串
     * 3，反转剩余字符串
     * */
    static String reverse(String s, int start, int end) {
        char[] sArrays = s.toCharArray();
        while (start < end) {
            //不需要额外空间，就能实现交换
            sArrays[start] ^= sArrays[end];
            sArrays[end] ^= sArrays[start];
            sArrays[start] ^= sArrays[end];
            start++;
            end--;
        }
        return new String(sArrays);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        String s = scan.next();
        s = reverse(s, 0, s.length() - 1);
        s = reverse(s, 0, index - 1);
        s = reverse(s, index, s.length() - 1);
        System.out.println(s);
    }

}
