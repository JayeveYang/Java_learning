package org.algorithm;
import java.util.LinkedList;
import java.util.Queue;
public class LeetCode_225 {
    /*
    * 题目
    * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
    * */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public LeetCode_225() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp;
        temp=q1;
        q1=q2;
        q2=temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
