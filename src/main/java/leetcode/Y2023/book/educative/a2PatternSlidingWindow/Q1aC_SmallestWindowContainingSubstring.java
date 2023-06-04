package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q1aC_SmallestWindowContainingSubstring {
    public String minWindow(String str, String pattern) {
        StringBuilder sb=new StringBuilder();
        int windowStart=0;
        int matched=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;
        Map<Character,Integer> charFreqMap=new HashMap<>();
        for (char c : pattern.toCharArray()) charFreqMap.merge(c,1,Integer::sum);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charFreqMap.containsKey(rightChar)){
                charFreqMap.merge(rightChar,-1,Integer::sum);
                if(charFreqMap.get(rightChar)==0)matched++;
            }
            while(matched==charFreqMap.size()){
                if(minLen>windowEnd-windowStart+1){
                    minLen=windowEnd-windowStart+1;
                    minStart=windowStart;
                }
                char leftChar = str.charAt(windowStart);
                if(charFreqMap.containsKey(leftChar)){
                    if(charFreqMap.get(leftChar)==0)matched--;
                    charFreqMap.merge(leftChar,1,Integer::sum);
                }
                windowStart++;
            }
        }
        if(minLen!=Integer.MAX_VALUE){
            for (int i = minStart; i < minStart+minLen; i++) {
                sb.append(str.charAt(i));
            }
            return sb.toString();
        }
        return "";

    }
}
