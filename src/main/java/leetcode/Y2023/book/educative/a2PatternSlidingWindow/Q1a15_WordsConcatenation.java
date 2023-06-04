package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q1a15_WordsConcatenation {
    public List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<String,Integer> wordFreqMap=new HashMap<>();
        for (String word : words) wordFreqMap.merge(word,1,Integer::sum);
        int wordLen=words[0].length();
        int wordsCount=words.length;
        for (int i = 0; i <= str.length()-wordLen*wordsCount; i++) {
            Map<String,Integer> seenMap=new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex=i+j*wordLen;
                String nextWord=str.substring(nextWordIndex,nextWordIndex+wordLen);
                if(!wordFreqMap.containsKey(nextWord))break;
                seenMap.merge(nextWord,1,Integer::sum);
                if(seenMap.get(nextWord)>wordFreqMap.get(nextWord))break;
                if(j+1==wordsCount)resultIndices.add(i);
            }
        }
        return resultIndices;

    }
    @Test
    public void test(){
        assertEquals(List.of(0,3),findWordConcatenation("catfoxcat",new String[]{"cat", "fox"}));
        assertEquals(List.of(3),findWordConcatenation("catcatfoxfox",new String[]{"cat", "fox"}));
    }
}
