package com.leetcode;

import java.util.Arrays;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/12/30 14:52
 */
public class Solution1046 {
    public Solution1046(){
        int[] stones={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
    public int lastStoneWeight(int[] stones) {
        int index=0;
        int length=stones.length;
        Arrays.sort(stones);
        while(index<length-1){
            if(stones[length-1]==stones[length-2]){
                index+=2;
                stones[length-2]=0;
            } else{
                stones[length-2]=stones[length-1]-stones[length-2];
                index++;
            }
            stones[length-1]=0;
            Arrays.sort(stones);
        }
        return stones[length-1];
    }
}
