package org.algorithm;

public class LeetCode_142 {
    /*
    * 题目
    * 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    * 说明：不允许修改给定的链表。
    *
    * */
    public ListNode detectCycle(ListNode head) {
        //设置快慢指针
        ListNode slow=head;
        ListNode fast=head;
        ListNode p=head,first=null;
        if(fast==null||fast.next==null)return null;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow.equals(fast)){
                first=slow;
                break;
            }
        }
        //无环，返回null
        if(first==null) return null;
        //有环，同时动起点和第一次相遇点，第二次遇见即为环入口
        while(!p.equals(first)){
            p=p.next;
            first=first.next;
        }
        return p;
    }
}
