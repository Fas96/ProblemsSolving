package leetcode.Y2023.weekly.w334;

import org.junit.Test;

import java.util.Arrays;

public class Q6369LeftAndRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int leftSum = 0, rightSum = 0;
        for (int nn:nums) rightSum += nn;

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return answer;

    }

    @Test
    public void test() {
        int[] nums = {1};
        int[] answer = leftRigthDifference(nums);
        System.out.println(Arrays.toString(answer));
    }
}
