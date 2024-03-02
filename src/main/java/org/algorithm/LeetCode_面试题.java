package org.algorithm;

public class LeetCode_面试题 {
    /*
    * 题目
    * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    *
    * 思路！！！
    * 我们求出两个链表的长度，并求出两个链表长度的差值，然后让curA移动到，和curB 末尾对齐的位置，
    * 此时我们就可以比较curA和curB是否相同，如果不相同，同时向后移动curA和curB，如果遇到curA == curB，则找到交点。
    * 否则循环退出返回空指针。
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        // 计算链表长度
        ListNode pA=headA, pB=headB;
        while(pA!=null){
            lenA++;
            pA=pA.next;
        }
        while(pB!=null){
            lenB++;
            pB=pB.next;
        }
        // headA记录较长链表
        if(lenA<lenB){
            ListNode temp=headA;
            headA=headB;
            headB=temp;
        }
        // 将两链表处理成一样的长度
        for(int i=0;i<Math.abs(lenA-lenB);i++){
            headA=headA.next;
        }
        while(headB!=null){
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
