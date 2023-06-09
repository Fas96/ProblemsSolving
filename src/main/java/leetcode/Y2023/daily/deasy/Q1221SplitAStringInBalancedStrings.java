package leetcode.Y2023.daily.deasy;

public class Q1221SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int ans = 0;

        int LCount=0, RCount=0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') LCount++;
            else RCount++;
            if(LCount == RCount) {
                ans++;
                LCount = 0;
                RCount = 0;
            }
        }
        return ans;
    }
}
