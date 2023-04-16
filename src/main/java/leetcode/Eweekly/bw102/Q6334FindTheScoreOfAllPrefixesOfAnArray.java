package leetcode.Eweekly.bw102;

import java.util.Arrays;

public class Q6334FindTheScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        int [] maxTillNow= new int[n];
        int max=nums[0];
        long[]prefixAns=new long[n];
        for (int i = 0; i < n; i++) {
            max=Math.max(max,nums[i]);
            maxTillNow[i]= nums[i]+ max;
        }
        prefixAns[0]=maxTillNow[0];

        for (int i = 1; i < n; i++) {
            prefixAns[i]=prefixAns[i-1]+maxTillNow[i];
        }


        return  prefixAns;

    }
}
