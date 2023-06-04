package leetcode.Y2023.daily.hard;

public class Q1416RestoreTheArray {
    public int numberOfArrays(String s, int k) {
        int MOD=1_000_000_007;
        long[] dp = new long[s.length()+1];
        int maxNumLength = String.valueOf(k).length();
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && i-j <= maxNumLength; j--) {
                if (isValidStart(s, j)) continue;
                String sub = s.substring(j, i);
                long n = Long.parseLong(sub);
                if (isValueInRange(k, n)) continue;
                dp[i] += dp[j];
                dp[i] %= MOD;
            }
        }
        return (int)dp[s.length()];
    }

    private static boolean isValueInRange(int k, long n) {
        return n > k;
    }

    private static boolean isValidStart(String s, int j) {
        return s.charAt(j) == '0';
    }
}
