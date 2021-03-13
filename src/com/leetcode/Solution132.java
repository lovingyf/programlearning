package com.leetcode;

import java.util.Arrays;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/8 10:35
 */
public class Solution132 {
    public Solution132() {
        String s = "aba";
        System.out.println(minCut(s));
    }
    public int minCut(String s) {
        int sLength=s.length();
        boolean[][] flag=new boolean[sLength][sLength];
        for(boolean[] i:flag){
            Arrays.fill(i,true);
        }
        for(int i=sLength-1;i>=0;--i){
            for(int j=i+1;j<sLength;++j){
                flag[i][j]=(s.charAt(i)==s.charAt(j)&&flag[i+1][j-1]);
            }
        }
        int[] f=new int[sLength];
        Arrays.fill(f,Integer.MAX_VALUE);
        for(int i=0;i<sLength;++i){
            if(flag[0][i])
                f[i]=0;
            else {
                for(int j=0;j<i;++j){
                    if(flag[j+1][i])
                        f[i]=Math.min(f[i],f[j]+1);
                }
            }
        }
        return f[sLength-1];
    }
}
