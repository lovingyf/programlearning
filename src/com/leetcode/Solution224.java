package com.leetcode;

import java.util.Stack;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/10 9:04
 */
public class Solution224 {
    public Solution224() {
        String s="(1+(4+5+2)-3)+(6+8)";
        String s1=" 2-1 + 2 ";
        System.out.println(calculate(s));
    }
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        int sign=1;
        int res=0;
        int sLength=s.length();
        int i=0;
        while (i<sLength){
            char op=s.charAt(i);
            if(op==' ')
                ++i;
            else if(op=='+'){
                sign=stack.peek();
                ++i;
            }else if(op=='-'){
                sign=-stack.peek();
                ++i;
            }else if(op=='('){
                stack.push(sign);
                ++i;
            }else if(op==')'){
                stack.pop();
                ++i;
            }else {
                int num=0;
                while (i<sLength&&Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    ++i;
                }
                res+=sign*num;
            }
        }
        return res;
    }
}
