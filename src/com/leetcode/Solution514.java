package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/11 10:37
 */
public class Solution514 {
    public Solution514(){
        int result=findRotateSteps("nyngl","yyynnnnnnlllggg");
        System.out.println(result);
    }
    public int findRotateSteps(String ring, String key) {
        int sumStep=0;
        int position=0;
        for(int i=0;i<key.length();i++){
            char goal=key.charAt(i);
            int temp=getStep(ring,position,goal);
            sumStep+=Math.abs(temp)+1;
            position=(position+temp+ring.length())%ring.length();
        }
        return sumStep;
    }
    public int getStep(String ring,int position,char goal){
        int ringLength=ring.length();
        int i=0,j=0;
        while(i<(ringLength+1)/2){
            if(ring.charAt((i+position)%ringLength)==goal)
                return i;
            if(ring.charAt((j+position+ringLength)%ringLength)==goal)
                return j;
            i++;
            j--;
        }
        return 0;
    }
}
