package com.algorithm;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/4 10:09
 */
public class Lis {
    public Lis() {
        int[] nums={4,2,3,1,5};
        System.out.println(getLIS2(nums));
    }
    public int getLIS1(int[] nums){
        if(nums.length<1)
            return -1;
        int maxLength=0;
        int numsLength=nums.length;
        int[] dp=new int[numsLength];
        dp[0]=1;
        for(int i=1;i<numsLength;++i){
            dp[i]=1;
            for(int j=0;j<i;++j){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        for(int i=0;i<numsLength;++i){
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
    public int getLIS2(int[] nums){
        int numsLength=nums.length;
        if (numsLength<1)
            return -1;
        int[] dp=new int[numsLength];
        int index=0;
        dp[index]=nums[0];
        for(int i=1;i<numsLength;++i){
            if(nums[i]>dp[index]){
                dp[++index]=nums[i];
            }else {
                int tempIndex=binarySearch(dp,0,index,nums[i]);
                dp[tempIndex]=nums[i];
            }
        }
        return index+1;
    }
    public int binarySearch(int[] nums,int begin,int end,int goal){
        while(begin<end){
            int mid=(begin+end)/2;
            if(nums[mid]>goal)
                end=mid;
            else begin=mid+1;
        }
        return end;
    }
}
