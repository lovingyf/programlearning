package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/2 10:29
 */
public class Solution304 {
    public Solution304() {
    }
    class NumMatrix {
        private int[][] sums;
        public NumMatrix(int[][] matrix) {
            int row=matrix.length;
            if(row==0)
                return;
            int col=matrix[0].length;
            sums=new int[row+1][col+1];
            for(int i=0;i<row;++i){
                for(int j=0;j<col;++j){
                    sums[i+1][j+1]=sums[i][j+1]+sums[i+1][j]+matrix[i][j]-sums[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]+sums[row1][col1];
        }
    }
}
