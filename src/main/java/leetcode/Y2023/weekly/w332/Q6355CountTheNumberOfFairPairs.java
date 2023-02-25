package leetcode.Y2023.weekly.w332;

import java.util.*;

public class Q6355CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length, lo = n-1, hi = n-1;
        long  ans = 0;
        for (int i = 0; i < n; ++i) {
            while (0 <= hi && nums[i] + nums[hi] > upper) --hi;
            while (0 <= lo && nums[i] + nums[lo] >= lower) --lo;
            ans += hi - lo;
            if (i > lo && i <= hi) --ans;
        }
        return ans/2;

    }


     
}
