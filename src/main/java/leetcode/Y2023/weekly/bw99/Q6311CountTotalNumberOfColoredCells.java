package leetcode.Y2023.weekly.bw99;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q6311CountTotalNumberOfColoredCells {
    public long coloredCells(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 4*(i-1);
        }
        return dp[n];
    }

    @Test
    public void testColoredCells(){
        assertEquals(1, coloredCells(1));
        assertEquals(5, coloredCells(2));
        assertEquals(13, coloredCells(3));
    }
}
