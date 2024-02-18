package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.List;

public class NC50链表中的节点每k个一组翻转 {

    /** 题目
     *  将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     *
     * 数据范围： 0≤n≤2000 ，1≤k≤2000 ，链表中每个元素都满足0≤val≤1000
     * 要求空间复杂度 O(1)，时间复杂度O(n)
     * 例如：
     * 给定的链表是 1→2→3→4→5
     * 对于 k=2 , 你应该返回 2→1→4→3→5
     * 对于 k=3 , 你应该返回 3→2→1→4→5
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        // 记录反转结束标记
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                // 不够长就不反转了
                return head;
            }
            end = end.next;
        }

        // 新链表头部
        ListNode pre = null;
        // 遍历链表指向
        ListNode cur = head;
        // 开始反转(头插法: ①记录下一个位置(用于遍历重新指向); ②下一个位置插到新链表头部; ③头部重新重指向; ④遍历重新指向)
        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroup(end, k);
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

        ListNode listNode = reverseKGroup(node1, 3);
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