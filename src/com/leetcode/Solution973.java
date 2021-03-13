package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/9 9:44
 */
public class Solution973 {
    public Solution973(){
        int[][] test={{3,3},{5,-1},{-2,4}};
        kClosest(test,2);
        System.out.println();
    }
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1];
            }
        });
        return Arrays.copyOf(points,K);
    }
}
