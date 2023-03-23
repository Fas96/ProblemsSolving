package leetcode.Y2023.weekly.w334;

import org.junit.Test;

import java.util.Arrays;

public class Q6368FindTheDivisibilityArrayOfAString {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] answer = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = word.charAt(i) - '0';

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum * 10 + nums[i]) % m;
            if (sum == 0) {
                answer[i] = 1;
            }
        }
        if (m == 1) {
            Arrays.fill(answer, 1);
        }
        else if (nums[0] == 0) {
            answer[0] = 1;
        }
        return answer;


    }

    @Test
    public void test() {
        String word = "1010";
        int m = 10;
        int[] answer = divisibilityArray(word, m);
        System.out.println(Arrays.toString(answer));
    }
}
