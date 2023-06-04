package leetcode.Y2023.book.educative.a3TwoPointers;

public class Q581ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int low=0,high=nums.length-1;
        //first number out of order from the beginning
        while (low<nums.length-1&&nums[low]<=nums[low+1]){
            low++;
        }
        if(low==nums.length-1){
            return 0;
        }
        //first number out of order from the end
        while (high>0&&nums[high]>=nums[high-1]){
            high--;
        }
        //find min and max in the middle
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int i = low; i <=high; i++) {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        //extend the subarray to include any number which is bigger than the min
        while (low>0&&nums[low-1]>min){
            low--;
        }
        //extend the subarray to include any number which is smaller than the max
        while (high<nums.length-1&&nums[high+1]<max){
            high++;
        }
        return high-low+1;

    }
}
