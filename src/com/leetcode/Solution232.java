package com.leetcode;

import java.util.Stack;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/5 9:52
 */
public class Solution232 {
    public Solution232() {
        MyQueue queue=new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
    class MyQueue {
        private int front;
        Stack<Integer> stackIn,stackOut;
        /** Initialize your data structure here. */
        public MyQueue() {
            stackIn=new Stack<>();
            stackOut=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(stackIn.isEmpty())
                front=x;
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stackOut.isEmpty()){
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stackOut.isEmpty())
                return front;
            return stackOut.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackIn.isEmpty()||stackOut.isEmpty();
        }
    }
}
