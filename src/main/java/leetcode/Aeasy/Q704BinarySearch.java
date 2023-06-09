package leetcode.Aeasy;

public class Q704BinarySearch {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length;
        while (low<high){
            int pivot=low +(high-low)/2;
            if (nums[pivot]==target)return pivot;
            else if (nums[pivot]>target)high=pivot+1;
            else low=pivot;
        }
        return -1;

    }
}
