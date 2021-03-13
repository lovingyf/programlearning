package com.leetcode;

import java.util.*;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2020/11/5 14:19
 */
public class Solution127 {
    public Solution127(){
        String beginWord="qa";
        String endWord="sq";
        List<String> list=new ArrayList<>();
        String[] strings={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        //String[] strings={"qb","bs","sq"};
        //List<String> list= Arrays.asList(strings);
        Collections.addAll(list,strings);
        System.out.println(ladderLength(beginWord,endWord,list));
    }
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord)<0)
            return 0;
        boolean[] flag=new boolean[wordList.size()];
        int result=findMinLength(beginWord,endWord,wordList,flag,0);
        if(result==Integer.MAX_VALUE)
            result=0;
        return result;
    }
    public int findMinLength(String beginWord, String endWord, List<String> wordList,boolean[] flag,int length){
        if(beginWord.equals(endWord))
            return length+1;
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<wordList.size();i++){
            if(!flag[i]&&findSameLetter(beginWord,wordList.get(i))){
                flag[i]=true;
                int templength=findMinLength(wordList.get(i),endWord,wordList,flag,length+1);
                minLength=Math.min(minLength,templength);
                flag[i]=false;
            }
        }
        return minLength;
    }
    public boolean findSameLetter(String str1,String str2){
        if(str1.length()==2){
            for(int i=0;i<2;i++){
                if(str1.charAt(i)==str2.charAt(0)||str1.charAt(i)==str2.charAt(1))
                    return true;
            }
        }
        int result=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
                result++;
        }
        return result==1;
    }*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);

        // 从两端 BFS 遍历要用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符
                    char c0 = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了，跳过
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回 count
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (allWordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    // 恢复第j位的原始字符
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; ++i) {
                String start = queue.poll();
                for (String s : wordList) {
                    // 已经遍历的不再重复遍历
                    if (visited.contains(s)) {
                        continue;
                    }
                    // 不能转换的直接跳过
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    // 用于调试
                    // System.out.println(count + ": " + start + "->" + s);
                    // 可以转换，并且能转换成 endWord，则返回 count
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }*/
}
