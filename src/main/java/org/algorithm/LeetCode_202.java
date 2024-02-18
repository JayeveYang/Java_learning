//https://leetcode.cn/problems/happy-number/description/

package org.algorithm;

import java.util.HashSet;

public class LeetCode_202 {
    /*
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果 可以变为  1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     * */

    /*
    * 思路
    *
    * 题目中说了会无限循环，那么也就是说求和的过程中，sum会重复出现
    * 又因为sum值并不是固定的，因此考虑用Set。
    * */

    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> hash_table = new HashSet<>();
        int sum = getSum(n);
        while(!hash_table.contains(sum) && sum != 1){
            //把当前sum加入HashSet
            hash_table.add(sum);
            //获得新的sum
            sum=getSum(sum);
        }
        return sum == 1;
    }
}
