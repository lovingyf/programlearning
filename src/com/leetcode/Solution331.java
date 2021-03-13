package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/12 9:10
 */
public class Solution331 {
    public Solution331() {
        String preorder = "9,3,4,#,#,1,##2,#,6,#,#";
        String s = "1##1";
        System.out.println(isValidSerialization(preorder));
    }

    public boolean isValidSerialization(String preorder) {
        int sLength = preorder.length();
        int top = 0;
        int[] stack = new int[sLength];
        stack[top]=1;
        boolean sign=true;
        for (int i = 0; i < sLength; ++i) {
            char op = preorder.charAt(i);
            if (op == '#') {
                if (top<0||--stack[top] < 0)
                    return false;
                else if (stack[top] == 0)
                    --top;
            } else if (op == ','){
                sign=true;
            }else if(sign){
                if (top<0||--stack[top] < 0)
                    return false;
                else if (stack[top] == 0)
                    --top;
                stack[++top] = 2;
                sign=false;
            }
        }
        if (stack[0] > 0)
            return false;
        return true;
    }
    public boolean isValidSerialization1(String preorder) {
        int sign=1;
        int i=0;
        int sLength=preorder.length();
        while (i<sLength){
            if(sign==0)
                return false;
            if(preorder.charAt(i)==',')
                i++;
            else if(preorder.charAt(i)=='#'){
                --sign;
                ++i;
            }else {
                while (i<sLength&&preorder.charAt(i)!=',')
                    i++;
                ++sign;
            }
        }
        return sign==0;
    }
}
