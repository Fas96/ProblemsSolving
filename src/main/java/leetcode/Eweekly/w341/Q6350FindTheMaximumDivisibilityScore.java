package leetcode.Eweekly.w341;

public class Q6350FindTheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = 0;
        int maxDivisor = Integer.MAX_VALUE;
        for (int i = 0; i < divisors.length; i++) {
            int divisor = divisors[i];
            int score = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisor == 0) {
                    score++;
                }
            }
            if (score > maxScore || (score == maxScore && divisor < maxDivisor)) {
                maxScore = score;
                maxDivisor = divisor;
            }
        }
        return maxDivisor;

    }
}
