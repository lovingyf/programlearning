package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/6 9:56
 */
public class Solution1356 {
    public Solution1356(){
        int[] arr={0,1,2,3,4,5,6,7,8};
        sortByBits(arr);
        System.out.println();
    }
    public int[] sortByBits(int[] arr) {
        int[][] flag = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            flag[i][0]=temp;
            while (temp != 0) {
                if (temp % 2 == 1) {
                    flag[i][1]++;
                }
                temp = temp / 2;
            }
        }
        Arrays.sort(flag, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=flag[i][0];
        }
        return result;
    }
}
