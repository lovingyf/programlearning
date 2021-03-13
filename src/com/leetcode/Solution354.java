package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/4 10:07
 */
public class Solution354 {
    public Solution354() {
        int[][] envelopes={{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes1={{4,5},{4,6},{6,7},{2,3},{1,1}};
        int[][] envelopes2={{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7}, {11, 19}, {8, 11},
                {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19},
                {16, 1}, {18, 13}, {14, 17}, {18, 19}};
        System.out.println(maxEnvelopes(envelopes2));
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        int envelopesLength=envelopes.length;
        int index=0;
        int[] dp=new int[envelopesLength];
        dp[index]=envelopes[index][1];
        for(int i=1;i<envelopesLength;++i){
            if(envelopes[i][1]>dp[index]){
                dp[++index]=envelopes[i][1];
            } else {
                int tempIndex=binarySearch(dp,0,index,envelopes[i][1]);
                dp[tempIndex]=envelopes[i][1];
            }
        }
        return index+1;
    }

    public int binarySearch(int[] nums,int left,int right,int goal){
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]>=goal)
                right=mid;
            else left=mid+1;
        }
        return right;
    }
}
