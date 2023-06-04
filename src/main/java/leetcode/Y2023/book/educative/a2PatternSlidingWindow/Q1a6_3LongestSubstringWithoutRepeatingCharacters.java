package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q1a6_3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
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
        assertEquals(3,lengthOfLongestSubstring("aabccbb"));
        assertEquals(2,lengthOfLongestSubstring("abbbb"));
        assertEquals(3,lengthOfLongestSubstring("abccde"));
        assertEquals(3,lengthOfLongestSubstring("pwwkew"));
        assertEquals(1,lengthOfLongestSubstring("bbbbb"));
        assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
    }
}
