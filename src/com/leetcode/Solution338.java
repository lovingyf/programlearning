package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/3 9:48
 */
public class Solution338 {
    public Solution338() {
        int num=5;
        int[] result=countBits2(num);
        for(int i:result)
            System.out.print(i);
        System.out.println();

    }
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        int index=0;
        result[index++]=0;
        while (index<=num){
            if((index&1)==1)
                result[index]=result[index-1]+1;
            else
                result[index]=result[index/2];
            ++index;
        }
        return result;
    }
    public int[] countBits2(int num){
        int[] result=new int[num+1];
        for(int i=1;i<=num;i++){
            result[i]=result[i&(i-1)]+1;
            //result[i]=result[i>>1]+(i&1);从0开始
        }
        return result;
    }
}
