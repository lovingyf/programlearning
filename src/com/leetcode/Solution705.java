package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/3/13 14:24
 */
public class Solution705 {
    public Solution705() {

    }
    class MyHashSet {
        private List<Integer> list;
        /** Initialize your data structure here. */
        public MyHashSet() {
            list=new ArrayList<>();
        }

        public void add(int key) {
            if(!list.contains(key))
                list.add(key);
        }

        public void remove(int key) {
            if(contains(key))
                list.remove(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return list.contains(key);
        }
    }
}
