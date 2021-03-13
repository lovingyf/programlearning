package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/8 10:34
 */
public class Solution131 {
    public Solution131() {
        String s = "aab";
        //System.out.println(isPalindromeString(s));
        List<List<String>> res=partition(s);
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<String>(), 0);
        return res;
    }

    public void dfs(String str, List<List<String>> res, List<String> temp, int index) {
        if(index==str.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < str.length(); ++i) {
            String tempStr = str.substring(index, i+1);
            if (isPalindromeString(tempStr)) {
                temp.add(tempStr);
                dfs(str, res, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindromeString(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
