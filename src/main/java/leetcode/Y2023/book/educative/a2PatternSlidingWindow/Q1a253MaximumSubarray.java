package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

public class Q1a253MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int windowSum=0;
        int max=Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum+=nums[windowEnd];
            max=Math.max(max,windowSum);
            if(windowSum<0){
                windowSum=0;
            }
        }
        return max;

    }
}
