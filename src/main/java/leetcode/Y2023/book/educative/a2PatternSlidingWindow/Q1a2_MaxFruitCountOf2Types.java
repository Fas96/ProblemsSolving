package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q1a2_MaxFruitCountOf2Types {
    public int findLength(char[] arr){
        int windowStart=0;
        int maxLen=Integer.MIN_VALUE;
        Map<Character,Integer> fruitFreqMap=new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            fruitFreqMap.merge(rightChar,1,Integer::sum);
            while (fruitFreqMap.size()>2){
                char leftChar = arr[windowStart];
                fruitFreqMap.merge(leftChar,-1,Integer::sum);
                if(fruitFreqMap.get(leftChar)==0){
                    fruitFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;
    }
    @Test
    public void test(){
        assertEquals(3,findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        assertEquals(5,findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
