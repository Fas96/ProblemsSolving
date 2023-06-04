package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QStringAnagrams {
    public List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int windowStart=0;
        int matched=0;
        int patternLen=pattern.length();
        Map<Character,Integer> charFreqMap=new HashMap<>();
        for (char c : pattern.toCharArray()) charFreqMap.merge(c,1,Integer::sum);
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charFreqMap.containsKey(rightChar)){
                charFreqMap.merge(rightChar,-1,Integer::sum);
                if(charFreqMap.get(rightChar)==0)matched++;
            }
            if(matched==charFreqMap.size())resultIndices.add(windowStart);
            if(windowEnd-windowStart+1==patternLen){
                char leftChar = str.charAt(windowStart);
                if(charFreqMap.containsKey(leftChar)){
                    if(charFreqMap.get(leftChar)==0)matched--;
                    charFreqMap.merge(leftChar,1,Integer::sum);
                }
                windowStart++;
            }
        }
        return resultIndices;


    }
}
