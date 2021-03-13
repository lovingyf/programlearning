package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/5 9:49
 */
public class Solution56 {
    public Solution56() {
        int[][] intervals = new int[][]{{1, 4},  {0, 2},{3, 5}};
        merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int[][] temp = new int[100][2];
        int[][] result;
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j=i;
            for(;j<intervals.length - 1;j++){
                if(end>intervals[j+1][1])
                    continue;
                if(!(end<intervals[j+1][0]))
                    end=intervals[j+1][1];
                else {
                    break;
                }
            }
            i=j;
            end = Math.max(intervals[i][1], end);
            temp[index][0] = start;
            temp[index++][1] = end;
        }
        result = new int[index][2];
        for (int i = 0; i < index; i++) {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }
        return result;
    }

}
