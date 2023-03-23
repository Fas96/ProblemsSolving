package leetcode.Y2023.daily.dmedium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q2294PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        //subsequence => sort it
        //subarray => not sort
        Arrays.sort(nums);
        int count =1;
        int start =0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-nums[start]>k)
            {
                count++;
                start =i;
            }
        }
        return count;

    }
}
