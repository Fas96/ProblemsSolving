package leetcode.Y2023.dfACC.tarr;

public class Q11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int N = height.length;
        int L = 0, R = N - 1;
        int ans = 0;
        while (L < R) {
            int h = Math.min(height[L], height[R]);
            ans = Math.max(ans, h * (R - L));
           if (height[L] < height[R])L++;
           else R--;

        }
        return ans;

    }
}
