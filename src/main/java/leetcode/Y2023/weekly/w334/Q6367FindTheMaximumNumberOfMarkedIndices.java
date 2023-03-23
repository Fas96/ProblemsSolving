package leetcode.Y2023.weekly.w334;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q6367FindTheMaximumNumberOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0, j = (nums.length + 1) / 2; j < nums.length; j++) {
            count += 2 * nums[i] <= nums[j] ? 2 : 0;
            i += 2 * nums[i] <= nums[j] ? 1 : 0;
        }
        return count;
    }


    @Test
    public void test() {
        int[] nums = {9,2,5,4};
        int answer = maxNumOfMarkedIndices(nums);
        System.out.println(answer);
    }
}
