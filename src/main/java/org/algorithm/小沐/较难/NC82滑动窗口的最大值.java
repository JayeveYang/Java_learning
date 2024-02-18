package org.algorithm.小沐.较难;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NC82滑动窗口的最大值 {
    /** 题目:
     *  给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     *
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     *    {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     *
     * 窗口大于数组长度或窗口长度为0的时候，返回空。
     *
     * 数据范围：1≤n≤10000，0≤size≤10000，数组中每个元素的值满足 ∣val∣≤10000
     * 要求：空间复杂度 O(n)，时间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */

    /** 双向链表法: 我们都知道，若是一个数字A进入窗口后，若是比窗口内其他数字都大，那么这个数字之前的数字都没用了，因为它们必定会比A早离开窗口，在A离开之前都争不过A，所以A在进入时依次从尾部排除掉之前的小值再进入，而每次窗口移动要弹出窗口最前面值，因此队首也需要弹出，所以我们选择双向队列。*/
    public static ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) {
            return list;
        }
        // 双向链表
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        // 遍历一个窗口大小
        for (int i = 0; i < size; i++) {
            while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                // 去掉比自己小的
                dq.pollLast();
            }
            dq.add(i);
        }

        // 开始滑动
        for (int i = size; i < num.length; i++) {
            // 取窗口最大值, 即第一个
            list.add(num[dq.peekFirst()]);
            while (!dq.isEmpty() && dq.peekFirst() < (i - size + 1)) {
                // 满了就要踢掉第一个
                dq.pollFirst();
            }
            while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                // 去掉比自己小的
                dq.pollLast();
            }
            dq.add(i);
        }
        list.add(num[dq.peekFirst()]);
        return list;
    }

    /** 暴力法: */
    public static ArrayList<Integer> maxInWindows1(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //窗口大于数组长度的时候，返回空
        if (size > num.length || size == 0) {
            return list;
        }

        //数组后面要空出窗口大小，避免越界
        for (int i = 0; i <= num.length - size; i++) {
            //寻找每个窗口最大值
            int max = 0;
            for (int j = i; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }


    public static void main(String[] args) {
        int[] num = {9,10,9,-7,-3,8,2,-6};
        ArrayList<Integer> list = maxInWindows(num, 3);
        list.forEach(System.out::println);
    }
}
