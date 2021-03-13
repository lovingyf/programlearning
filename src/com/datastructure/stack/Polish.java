package com.datastructure.stack;

import java.util.*;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/10 20:16
 */
public class Polish {
    private Map<Character, Integer> opMap;

    public Polish() {
        //init data;
        initOperatorPriority();
        String infixExpression = "(2+553)*(1-663)+3/(244+1)";

        //test function
        Queue<String> queue=infixToPostfix(infixExpression);
        System.out.println(queue);
        System.out.println(calculatePostfix(queue));
    }

    public void initOperatorPriority() {
        opMap = new HashMap<>();
        opMap.put('(', 0);
        opMap.put('-', 1);
        opMap.put('+', 1);
        opMap.put('*', 2);
        opMap.put('/', 2);
    }

    public Double calculatePostfix(Queue<String> postQuene) {
        Double res = 0.0;
        Stack<Double> stack = new Stack<>();
        while (!postQuene.isEmpty()) {
            String str = postQuene.poll();
            if (str.equals("+")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(a + b);
            } else if (str.equals("-")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b - a);
            } else if (str.equals("*")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(a * b);
            } else if (str.equals("/")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Double.valueOf(str));
            }
        }
        return stack.pop();
    }
    public Queue<String> infixtoPrefix(String exp){

    }
    public Queue<String> infixToPostfix(String exp) {
        //输出队列
        Queue<String> postQuene = new LinkedList<>();
        //符号栈
        Stack<Character> stack = new Stack<>();

        int expLength = exp.length();
        int i = 0;

        while (i < expLength) {
            char op = exp.charAt(i);
            if (Character.isDigit(op)) {
                String num = "";
                while (Character.isDigit(op)) {
                    num += op;
                    ++i;
                    op = exp.charAt(i);
                }
                postQuene.offer(num);
                num = "";
                --i;
            } else if (op == '(') {
                stack.push(op);
            } else if (op == ')') {
                while (stack.peek() != '(')
                    postQuene.offer(stack.pop().toString());
                stack.pop();
            } else {
                while (!stack.isEmpty() && !(opMap.get(op) > opMap.get(stack.peek())))
                    postQuene.offer(stack.pop().toString());
                stack.push(op);
            }
            i++;
        }
        while (!stack.isEmpty())
            postQuene.offer(stack.pop().toString());
        return postQuene;
    }
}

/*
        for (int i = 0; i < exp.length(); ++i) {
        char op=exp.charAt(i);
        if(Character.isDigit(op)){
        postfixQuene.append(op);
        }else if(op=='('){
        stack.push(op);
        }else if(op==')'){
        while (stack.peek()!='(')
        postfixQuene.append(stack.pop());
        stack.pop();
        }else {
        if(stack.isEmpty())
        stack.push(op);
        else if(map.get(op)>map.get(stack.peek()))
        stack.push(op);
        else {

        }
        }
        }
        while (!stack.isEmpty()){
        postfixQuene.append(stack.pop());
        }
        return postfixQuene.toString();*/
