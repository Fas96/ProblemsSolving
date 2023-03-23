package leetcode.Y2023.weekly.w337;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q6321SmallestMissingNonnegativeIntegerAfterOperations {
    public int findSmallestInteger(int[] nums, int value) {
        int[] f = new int[value];
        for (int x : nums) {
            int r = x % value;
            if (r < 0) r += value;
            f[r]++;
        }

        int i = 0;
        for (int res = 0; ; ++res) {
            if (f[i] == 0) return res;
            f[i]--;
            ++i;
            if (i == value) i = 0;
        }


    }
    @Test
    public void test() {
        assertEquals(4, findSmallestInteger(new int[]{1,-10,7,13,6,8}, 5));
        assertEquals(2, findSmallestInteger(new int[]{1,-10,7,13,6,8}, 7));
    }
}
