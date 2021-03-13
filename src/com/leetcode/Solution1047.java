package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/9 9:16
 */
public class Solution1047 {
    public Solution1047() {
        String str="abbaca";
        System.out.println(removeDuplicates1(str));
    }
    public String removeDuplicates(String S) {
        int i=1;
        while (i<S.length()){
            if(S.charAt(i-1)==S.charAt(i)){
               S=S.substring(0,i-1)+S.substring(i+1);
               if(i>1)
                   --i;
            }else
                i++;
        }
        return S;
    }
    public String removeDuplicates1(String S) {
        char[] stack=S.toCharArray();
        int top=-1;
        for(int i=0;i<S.length();++i){
            if(top==-1||stack[top]!=stack[i])
                stack[++top]=stack[i];//push stack
            else top--;//pop stack
        }
        return String.valueOf(stack,0,top+1);
    }
}
