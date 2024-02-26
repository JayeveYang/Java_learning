package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.List;

public class NC40链表相加二 {
    /**
     * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     * 数据范围：0 ≤ n,m ≤ 1000000，链表任意值 0 ≤ val ≤ 9
     * 要求：空间复杂度 O(n)，时间复杂度 O(n)
     * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // 反转链表
        head1 = reversalListNode(head1);
        head2 = reversalListNode(head2);

        // 记录进位
        int carry = 0;
        int var1 = 0;
        int var2 = 0;
        int newVar = 0;

        ListNode newListNode = new ListNode(0);
        ListNode head = newListNode;

        // 遍历链表
        while (head1 != null || head2 != null || carry != 0) {
            var1 = head1 == null ? 0: head1.val;
            var2 = head2 == null ? 0: head2.val;

            newVar = var1 + var2 + carry;

            ListNode temp = new ListNode(newVar % 10);
            newListNode.next = temp;
            newListNode = temp;
            carry = newVar / 10;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return reversalListNode(head.next);
    }

    public static ListNode reversalListNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        // 头插法
        while (cur != null) {
            // 断开
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            // 重新记录
            cur = temp;
        }
        return pre;
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

        ListNode nodeNew1 = new ListNode(1);
        ListNode nodeNew2 = new ListNode(2);
        ListNode nodeNew3 = new ListNode(3);
        ListNode nodeNew4 = new ListNode(4);

        nodeNew1.next = nodeNew2;
        nodeNew2.next = nodeNew3;
        nodeNew3.next = nodeNew4;

        ListNode listNode = addInList(node1, nodeNew1);
        List<Integer> list = new ArrayList<>();

        while(listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        list.forEach(System.out::println);
    }
}
