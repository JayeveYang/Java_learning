package org.algorithm.小沐.简单;

import java.util.ArrayList;
import java.util.List;

public class NC78反转链表 {
    /** 题目
     *  给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
     *  数据范围： 0 ≤ n ≤1 000
     * 要求：空间复杂度 O(1) ，时间复杂度 O(n)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode ReverseList (ListNode head) {
        // write code here
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;

        while(cur != null) {
            // 确定下一个的位置
            temp = cur.next;

            // 头插法
            cur.next = pre;
            pre = cur;

            cur = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode listNode = ReverseList(node1);
        List<Integer> list = new ArrayList<>();

        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        list.forEach(System.out::println);
    }

}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}