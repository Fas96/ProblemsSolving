package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

public class Q1a3_152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int windowSum=1;
        int max=Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum*=nums[windowEnd];
            max=Math.max(max,windowSum);
        }
        return max;
    }
}
