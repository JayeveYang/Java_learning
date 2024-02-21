package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.List;

public class NC70单链表的排序 {
    /** 题目
     *  给定一个节点数为n的无序单链表，对其按升序排序。
     *
     * 数据范围：0 < n ≤ 100000，保证节点权值在[−10^9, 10^9]之内。
     * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head;
        ListNode mid = head.next;
        ListNode end = head.next.next;
        // 找到链表中间位置
        while (end != null && end.next != null) {
            // mid 走一步, end 走两步
            start = start.next;
            mid = mid.next;
            end = end.next.next;
        }

        // 中间断开链表
        start.next = null;

        // 递归拆分与合并
        return mergeSort(sortInList(head), sortInList(mid));
    }

    private static ListNode mergeSort(ListNode start, ListNode mid) {
        // 为空就返回另一个
        if (start == null) {
            return mid;
        }
        if (mid == null) {
            return start;
        }

        // 创建一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;

        // 开始排序
        while (mid != null && start != null) {
            if (start.val < mid.val) {
                cur.next = start;
                start = start.next;
                cur = cur.next;
                continue;
            }
            cur.next = mid;
            mid = mid.next;
            cur = cur.next;
        }

        // 如果还有剩下的就直接插进去
        cur.next = start != null ? start : mid;

        // 去掉表头
        return head.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode listNode = sortInList(node1);
        List<Integer> list = new ArrayList<>();

        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        list.forEach(System.out::println);
    }
}

