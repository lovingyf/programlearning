package com.leetcode;

import java.util.Stack;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/11 9:58
 */
public class Solution227 {
    public Solution227() {
        String s = "42";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int num = 0;
        int sLength = s.length();
        for (int i = 0; i < sLength; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == sLength - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
