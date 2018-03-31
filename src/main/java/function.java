
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class Solution {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();

        start.add(beginWord);
        end.add(endWord);
        return solve(start, end, wordList, 1);
    }
    public int solve(Set<String> start,Set<String> end,Set<String> wordList,int step){
        if(start.isEmpty()){
            return 0;
        }
        if(start.size()>end.size()){
            return solve(end,start,wordList,step);
        }
        wordList.removeAll(start);

        Set<String> next = new HashSet<String>();
        for(String s : start){
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                for (int j = 'a'; j <='z'; j++) {
                    char t = chs[i];
                    chs[i]=(char) j;
                    String temp = new String(chs);
                    if(end.contains(temp)){
                        return step+1;
                    }
                    if(wordList.contains(temp)){
                        next.add(temp);
                    }
                    chs[i] = t;
                }
            }
        }
        return solve(next, end, wordList, step+1);
    }
    @Test
    public void test(){
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dog");
        set.add("dot");
        ladderLength("hot","dog",set);
    }
}
