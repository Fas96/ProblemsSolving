package leetcode.Y2023.daily.dmedium;

import java.util.HashMap;
import java.util.Map;

public class Q1639NumberOfWaysToFormATargetStringGivenADictionary {
    public int numWaysA(String[] words, String target) {
        final int MOD = (int) 1e9 + 7;
        int targetLength = target.length();

        long dp[] = new long[targetLength + 1];
        dp[0] = 1;

        for (int i = 0; i < words[0].length(); i++) {
            Map<Character, Integer> cntMap = new HashMap<>();
            for (String w : words) {
                cntMap.merge(w.charAt(i), 1, Integer::sum);
            }
            for (int j = targetLength - 1; j >= 0; j--) {
                dp[j + 1] += (dp[j] * cntMap.getOrDefault(target.charAt(j), 0)) % MOD;
            }
        }

        return (int) (dp[targetLength] % MOD);
    }
    private static final int MOD = 1000000007;

    public int numWays(String[] words, String target) {
        int k = words[0].length();
        int m = target.length();
        int[][] cnt = new int[k][26];

        for (int i = 0; i < k; i++) {
            for (String word : words) {
                cnt[i][word.charAt(i) - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        return (int) dfs(0, 0, m, cnt, target, memo);
    }

    private long dfs(int i, int t, int m, int[][] cnt, String target, Map<String, Integer> memo) {
        if (t == m) {
            return 1;
        }
        if (i >= cnt.length) {
            return 0;
        }

        String key = i + "_" + t;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long res = 0;
        if (cnt[i][target.charAt(t) - 'a'] > 0) {
            res += cnt[i][target.charAt(t) - 'a'] * dfs(i + 1, t + 1, m, cnt, target, memo);
        }
        res += dfs(i + 1, t, m, cnt, target, memo);

        res %= MOD;
        memo.put(key, (int) res);
        return res;
    }
}
