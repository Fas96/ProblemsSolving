package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q1aC_PermutationInAString {
    public boolean findPermutation(String str,String pattern){
        int windowStart=0;
        int matched=0;
        Map<Character,Integer> charFrequencyMap=new HashMap<>();
        for (char c : pattern.toCharArray()) charFrequencyMap.merge(c,1,Integer::sum);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.merge(rightChar,-1,Integer::sum);
                if(charFrequencyMap.get(rightChar)==0)matched++;
            }
            if(matched==charFrequencyMap.size())return true;
            if(windowEnd-windowStart+1==pattern.length()){
                char leftChar = str.charAt(windowStart);
                if(charFrequencyMap.containsKey(leftChar)){
                    if(charFrequencyMap.get(leftChar)==0)matched--;
                    charFrequencyMap.merge(leftChar,1,Integer::sum);
                }
                windowStart++;
            }
        }
        return false;
    }
    @Test
    public void test(){
       assertEquals(true,findPermutation("oidbcaf","abc"));
       assertEquals(false,findPermutation("odicf","dc"));
       assertEquals(true,findPermutation("bcdxabcdy","bcdyabcdx"));
       assertEquals(true,findPermutation("aaacb","abc"));

    }
}
