package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q1a2_LongestSubstringKDistinct {
    public int findLength(String str, int k) {
       if(str==null || str.length()==0 || k==0)  return 0;
       int windowStart=0,maxLen=0;
        Map<Character,Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFreqMap.merge(rightChar,1,Integer::sum);
            while (charFreqMap.size()>k){
                char leftChar = str.charAt(windowStart);
                charFreqMap.merge(leftChar,-1,Integer::sum);
                if(charFreqMap.get(leftChar)==0){
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;

    }
    @Test
    public void test(){
      assertEquals(2,findLength("araaci",1));
      assertEquals(4,findLength("araaci",2));
      assertEquals(5,findLength("cbbebi",3));
    }
}
