package leetcode.Y2023.weekly.w336;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class Q6316RearrangeArrayToMaximizePrefixScore {
    public int maxScore(int[] nums) {
        int max = 0;
        long sum = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                max++;
            } else {
                break;
            }
        }
        return max;

    }
    @Test
    public void maxScoreTest(){

        assertEquals(6,maxScore(new int[]{2,-1,0,1,-3,3,-3}));
        assertEquals(0,maxScore(new int[]{-2,-3,0}));
    }
}
