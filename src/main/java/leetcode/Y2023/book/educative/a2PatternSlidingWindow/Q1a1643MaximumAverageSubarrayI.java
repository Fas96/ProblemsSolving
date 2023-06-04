package leetcode.Y2023.book.educative.a2PatternSlidingWindow;

public class Q1a1643MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max=Integer.MIN_VALUE;
        int windowSum=0;
        int windowStart=0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum+=nums[windowEnd];
            if(windowEnd>=k-1){
                max=Math.max(max,windowSum);
                windowSum-=nums[windowStart];
                windowStart++;
            }
        }
        return (max==Integer.MIN_VALUE)?0:max;

    }
}
