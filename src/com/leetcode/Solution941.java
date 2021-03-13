package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/3 15:31
 */
public class Solution941 {
        public Solution941(){
            int[] A={1,2,3,4,5,6};
            System.out.println(validMountainArray(A));
        }
        public boolean validMountainArray(int[] A) {
                if(A.length<3)
                    return false;
                int i=0,j=A.length-1;
                while(i<A.length-2&&A[i]<A[i+1])
                    i++;
                while(j>1&&A[j]<A[j-1])
                    j--;
                if(i==j)
                    return true;
                else
                    return false;





























/*            boolean flag=false;
            if(A.length<3)
                return false;
            int i=-1;
            if(A[0]>A[1])
                return false;
            do{
                i++;
                if(i==A.length-1)
                    return flag;
                if(A[i]==A[i+1]){
                    return false;
                }
                if(A[i]>A[i+1])
                    flag=true;
            }while(A[i]<A[i+1]^flag);

            return false;*/

        }
}
