package leetcode.Y2023.daily.dmedium;

import java.util.TreeSet;

public class Q300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int N=nums.length;
        if(N==0) return 0;
        int ans=1;
        for (int i = 0; i < N; i++) {
            int max=1;
            int prev= nums[i];
            for (int j = i+1; j < N; j++) {
                if(nums[j]>prev) {
                    max++;
                    prev = nums[j];
                }else{
                    prev=nums[i];
                }

            }
            ans=Math.max(ans,max);

        }

        return ans;
    }
}
