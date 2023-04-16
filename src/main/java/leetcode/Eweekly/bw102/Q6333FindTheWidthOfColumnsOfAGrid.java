package leetcode.Eweekly.bw102;

public class Q6333FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidth(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 0;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int len = String.valueOf(grid[i][j]).length();
                ans[j] = Math.max(ans[j], len);
            }
        }

        return ans;

    }
}
