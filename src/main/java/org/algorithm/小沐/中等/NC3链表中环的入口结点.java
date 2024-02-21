package org.algorithm.小沐.中等;


public class NC3链表中环的入口结点 {

    /**
     * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
     *
     * 数据范围：n≤10000，1<=结点值<=10000
     * 要求：空间复杂度 O(1)，时间复杂度O(n)
     */

    /**
     * 思路
     * 现在假定已经是一个有环的链表了，那么这个链表中怎么找到环的入口呢？在慢指针进入链表环之前，快指针已经进入了环，且在里面循环，
     * 这才能在慢指针进入环之后，快指针追到了慢指针，不妨假设快指针在环中走了n圈，慢指针在环中走了m圈，它们才相遇，
     * 而进入环之前的距离为x，环入口到相遇点的距离为y，相遇点到环入口的距离为z。
     * 快指针一共走了x+n(y+z)+y步，慢指针一共走了x+m(y+z)+y，这个时候快指针走的倍数是慢指针的两倍，则 x+n(y+z)+y=2(x+m(y+z)+y)，
     * 这时候x+y=(n−2m)(y+z)，因为环的大小是y+z，说明从链表头经过环入口到达相遇地方经过的距离等于整数倍环的大小：
     * 那我们从头开始遍历到相遇位置，和从相遇位置开始在环中遍历，会使用相同的步数，而双方最后都会经过入口到相遇位置这y个节点，
     * 那说明这y个节点它们就是重叠遍历的，那它们从入口位置就相遇了，这我们不就找到了吗？
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        // 判断是否有环
        ListNode slow = hasCycle(pHead);

        if (slow == null) {
            // 没有环
            return null;
        }

        ListNode head = pHead;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return slow;
    }

    private static ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 如果有环就不会结束
        while (fast.next != null && fast.next.next != null) {

            // 快指针2步, 慢指针1步
            fast = fast.next.next;
            slow = slow.next;

            // 相遇就结束
            if (fast == slow) {
                return slow;
            }
        }

        return null;
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
        node7.next = node4;

        EntryNodeOfLoop(node1);
    }
}
