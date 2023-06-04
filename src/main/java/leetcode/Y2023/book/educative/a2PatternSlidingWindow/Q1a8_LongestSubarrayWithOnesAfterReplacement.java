package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1a8_LongestSubarrayWithOnesAfterReplacement {
    public int SubarrayWithOnesAfterReplacement(int[] arr, int k) {
        int windowStart=0;
        int maxLen=0;
        int maxOnesCount=0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd]==1)maxOnesCount++;

            if(windowEnd-windowStart+1-maxOnesCount>k){
                if(arr[windowStart]==1)maxOnesCount--;

                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;
    }

    @Test
    public void test(){
        assertEquals(6,SubarrayWithOnesAfterReplacement(new int[]{0,1,1,0,0,0,1,1,0,1,1},2));
        assertEquals(9,SubarrayWithOnesAfterReplacement(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
        assertEquals(10,SubarrayWithOnesAfterReplacement(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }

}
