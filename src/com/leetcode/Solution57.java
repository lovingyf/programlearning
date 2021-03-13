package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/5 11:18
 */
public class Solution57 {
    public Solution57(){
        int[][] intervals={{1,3},{6,9},{10,11}};
        int[] newIntervals={2,5};
        insert(intervals,newIntervals);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp=new int[100][2];
        int new_length=intervals.length+1;
        int[][] intervals2=new int[new_length][2];
        for(int i=0;i<intervals.length;i++)
            intervals2[i]=intervals[i].clone();
        intervals2[intervals2.length-1][0]=newInterval[0];
        intervals2[intervals2.length-1][1]=newInterval[1];
        Arrays.sort(intervals2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int[][] result;
        int index=0;
        for(int i=0;i<intervals2.length;i++){
            int start=intervals2[i][0];
            int end=intervals2[i][1];
            int j=i;
            for(;j<intervals2.length - 1;j++){
                if(end>intervals2[j+1][1])
                    continue;
                if(!(end<intervals2[j+1][0]))
                    end=intervals2[j+1][1];
                else {
                    break;
                }
            }
            i=j;
            end=Math.max(intervals2[i][1],end);
            temp[index][0]=start;
            temp[index++][1]=end;
        }
        result=new int[index][2];
        for(int i=0;i<index;i++){
            result[i][0]=temp[i][0];
            result[i][1]=temp[i][1];
        }
        System.out.println();
        return result;
    }
}
