package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class QNoRepeatingSubstring {
    public int findLength(String str) {
        int windowStart=0,maxLen=0;
        Map<Character,Integer> charIndexMap=new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charIndexMap.containsKey(rightChar)){
                windowStart=Math.max(windowStart,charIndexMap.get(rightChar)+1);
            }
            charIndexMap.put(rightChar,windowEnd);
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;
    }
    @Test
    public void test(){
        assertEquals(3,findLength("aabccbb"));
        assertEquals(2,findLength("abbbb"));
        assertEquals(3,findLength("abccde"));
    }
}
