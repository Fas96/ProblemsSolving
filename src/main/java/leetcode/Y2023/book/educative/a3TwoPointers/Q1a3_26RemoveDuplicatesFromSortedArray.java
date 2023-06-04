package leetcode.Y2023.book.educative.a3TwoPointers;

public class Q1a3_26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int nextNonDuplicate=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[nextNonDuplicate-1]){
                nums[nextNonDuplicate]=nums[i];
                nextNonDuplicate++;
            }

        }

        return nextNonDuplicate;

    }
}
