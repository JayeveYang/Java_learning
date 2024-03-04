package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.List;

public class NC21链表内指定区间反转 {

    /** 题目
     *  将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
     * 例如：
     * 给出的链表为 1→2→3→4→5→NULL, m=2,n=4,
     * 返回 1→4→3→2→5→NULL.
     *
     * 数据范围： 链表长度0<size≤1000，0<m≤n≤size，链表中每个节点的值满足 ∣val∣≤1000
     * 要求：时间复杂度 O(n) ，空间复杂度 O(n)
     * 进阶：时间复杂度 O(n)，空间复杂度 O(1)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode pre = newNode;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode temp;
        for (int i = 0; i < n - m; i++) {
            // 记录位置
            temp = cur.next;
            // 连接下一个位置
            cur.next = cur.next.next;
            // 插进去
            temp.next = pre.next;
            pre.next = temp;
        }

        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode listNode = reverseBetween(node1, 3, 5);
        List<Integer> list = new ArrayList<>();

        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        list.forEach(System.out::println);
    }

}
