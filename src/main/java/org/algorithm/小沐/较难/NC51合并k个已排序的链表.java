package org.algorithm.小沐.较难;

import java.util.ArrayList;

public class NC51合并k个已排序的链表 {

    /** 题目
     *  合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
     *
     *  数据范围：节点总数  0≤n≤5000，每个节点的val满足 ∣val∣<=1000
     * 要求：时间复杂度 O(nlogn)
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public static ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        int size = lists.size();
        if (size <= 1) {
            return size == 0 ? null: lists.get(0);
        }
        ListNode listNode = null;
        for (int i = 0; i < size; i++) {
            // 归并
//            listNode = merge(listNode, lists.get(i));
            // 递归
            listNode = mergeLists(listNode, lists.get(i));
        }

        return listNode;
    }


    public static ListNode merge(ListNode listNodeLeft, ListNode listNodeRight) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        // 按照两个链表中的大小排，直到有一个链表排完了
        while (listNodeLeft != null && listNodeRight != null) {
            ListNode temp = new ListNode(Math.min(listNodeLeft.val, listNodeRight.val));
            head.next = temp;
            head = temp;
            if (listNodeLeft.val > listNodeRight.val) {
                listNodeRight = listNodeRight.next;
            } else {
                listNodeLeft = listNodeLeft.next;
            }
        }

        // 没排完的直接进前进
        while (listNodeLeft != null) {
            ListNode temp = new ListNode(listNodeLeft.val);
            head.next = temp;
            head = temp;
            listNodeLeft = listNodeLeft.next;
        }
        while (listNodeRight != null) {
            ListNode temp = new ListNode(listNodeRight.val);
            head.next = temp;
            head = temp;
            listNodeRight = listNodeRight.next;
        }

        return listNode.next;
    }


    public static ListNode mergeLists(ListNode listNodeLeft,ListNode listNodeRight){
        if(listNodeLeft == null || listNodeRight == null){
            return listNodeLeft == null ? listNodeRight: listNodeLeft;
        }
        if(listNodeLeft.val > listNodeRight.val){
            listNodeRight.next = mergeLists(listNodeLeft, listNodeRight.next);
            return listNodeRight;
        } else {
            listNodeLeft.next = mergeLists(listNodeLeft.next, listNodeRight);
            return listNodeLeft;
        }

    }

    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(0);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        lists.add(listNode1);
        lists.add(listNode4);

        ListNode listNode = mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
   int val;
   ListNode next = null;
   public ListNode(int val) {
     this.val = val;
   }
 }
