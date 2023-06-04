package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class QCharacterReplacement {
    public int LongestSubstringWithSameLettersAfterReplacement(String str,int k){
        int windowStart=0;
        int maxLen=0;
        int maxRepeatLetterCount=0;
        Map<Character,Integer> charFrequencyMap=new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.merge(rightChar,1,Integer::sum);
            maxRepeatLetterCount=Math.max(maxRepeatLetterCount,charFrequencyMap.get(rightChar));
            if(windowEnd-windowStart+1-maxRepeatLetterCount>k){
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.merge(leftChar,-1,Integer::sum);
                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;

    }
    @Test
    public void test(){
        assertEquals(5,LongestSubstringWithSameLettersAfterReplacement("aabccbb",2));
        assertEquals(4,LongestSubstringWithSameLettersAfterReplacement("abbcb",1));
        assertEquals(3,LongestSubstringWithSameLettersAfterReplacement("abccde",1));
        assertEquals(4,LongestSubstringWithSameLettersAfterReplacement("AABABBA",1));
        assertEquals(4,LongestSubstringWithSameLettersAfterReplacement("ABAB",2));
    }
}
