package leetcode.Y2023.daily.dmedium;

import static leetcode.Y2023.weekly.w331.Q6347CountVowelStringsInRanges.isVowel;

public class Q1456MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;
            if (i >= k && isVowel(s.charAt(i - k))) count--;
            ans = Math.max(ans, count);
        }
        return ans;

    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
