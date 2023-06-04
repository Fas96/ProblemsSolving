package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q1a5_2401LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int windowStart=0;
        int maxLen=1;
        int windowANDOP=0;
        for (int windowEnd = 1; windowEnd < nums.length; windowEnd++) {
            windowANDOP&=nums[windowEnd];
            while (windowANDOP!=0){
                int leftChar = nums[windowStart];
                windowANDOP&=leftChar;
                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;

    }
}
