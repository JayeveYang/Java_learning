package org.algorithm;
import java.util.Stack;
public class LeetCode_232 {
    /*
    * 题目
    * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
    * 实现每个操作均摊时间复杂度为 O(1) 的队列
    * */
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public LeetCode_232() {
        stackIn=new Stack<>();
        stackOut=new Stack<>();
    }

    public void push(int x) {

        stackIn.push(x);
    }

    public int pop() {
        if(stackOut.empty()){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if(stackOut.empty()){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty()&&stackOut.empty();
    }
}
