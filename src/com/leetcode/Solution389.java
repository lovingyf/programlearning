package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/12/18 14:29
 */
public class Solution389 {
    public Solution389(){
        String s="abcd";
        String t="abcde";
        System.out.println(findTheDifference(s,t));
    }
    public char findTheDifference(String s, String t) {
        int[] flag=new int[26];
        for(int i=0;i<s.length();i++){
            flag[(int)s.charAt(i)-97]++;
        }
        for(int i=0;i<t.length();i++){

            if(--flag[(int)t.charAt(i)-97]<0)
                return t.charAt(i);
        }
        return 0;
    }
}
