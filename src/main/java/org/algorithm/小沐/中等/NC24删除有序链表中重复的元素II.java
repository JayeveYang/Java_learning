package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.List;

public class NC24删除有序链表中重复的元素II {
    /**
     * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
     * 例如：
     * 给出的链表为1→2→3→3→4→4→5, 返回1→2→5.
     * 给出的链表为1→1→1→2→3, 返回2→3.
     *
     * 数据范围：链表长度0≤n≤10000，链表中的值满足 ∣val∣≤1000
     * 要求：空间复杂度O(n)，时间复杂度 O(n)
     * 进阶：空间复杂度 O(1)，时间复杂度 O(n)
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null ) {
            return null;
        }

        // 加个表头: 便于删除第一个
        ListNode node = new ListNode(0);
        node.next = head;

        // 开始遍历
        ListNode cur = node;
        while (cur.next != null && cur.next.next != null) {

            int temp = cur.next.val;
            // 遇到相同的
            if (cur.next.val == cur.next.next.val) {
                // 跳过相同的: 从当前就开始
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                // 确保当前没有相同的
                cur = cur.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode listNode = deleteDuplicates(node1);
        List<Integer> list = new ArrayList<>();

        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        list.forEach(System.out::println);
    }
}
