package leetcode.Y2023.weekly.w335;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q6310NumberOfWaysToEarnPoints {
   
    @Test
    public void test_waysToReachTarget(){ 
        assertEquals(7, waysToReachTarget(6, new int[][]{{6,1},{3,2},{2,3}})); 
        assertEquals(4, waysToReachTarget(5, new int[][]{{50,1},{50,2},{50,5}}));
    }

    private int waysToReachTarget(int target, int[][] types) {
        final int mod = 1000000007;
        int n = target;
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int[] t : types){
            long[] ndp = new long[n+1];
            int c = t[0], m = t[1];
            for(int d = 0;d < m;d++){
                long s = 0;
                for(int i = d, j = d-(c+1)*m;i <= n;i+=m, j+=m){
                    s += dp[i];
                    if(s >= mod)s -= mod;
                    if(j >= 0){
                        s -= dp[j];
                        if(s < 0)s += mod;
                    }
                    ndp[i] = s;
                }
            }
            dp = ndp;
        }
        return (int)dp[n];

    }
}
