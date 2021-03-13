package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/1 19:09
 */
public class Solution303 {
    public Solution303() {

    }
    class NumArray {
        private int[] sums;
        public NumArray(int[] nums) {
            sums=new int[nums.length+1];
            sums[0]=0;
            for(int i=0;i<nums.length;i++){
                sums[i+1]=sums[i]+nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j+1]-sums[i];
        }
    }
}
