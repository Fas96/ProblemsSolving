package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q1a4_904FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int windowStart=0;
        int maxLen=Integer.MIN_VALUE;
        Map<Integer,Integer> fruitFreqMap=new HashMap<>();
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            int rightChar = fruits[windowEnd];
            fruitFreqMap.merge(rightChar,1,Integer::sum);
            while (fruitFreqMap.size()>2){
                int leftChar = fruits[windowStart];
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
}
