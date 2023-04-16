package leetcode.Eweekly.w341;

public class Q6376RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = 0;
        int maxOnesRow = 0;
        for (int i = 0; i < mat.length; i++) {
            int ones = countOnes(mat[i]);
            if (ones > maxOnes) {
                maxOnes = ones;
                maxOnesRow = i;
            }
        }
        return new int[]{maxOnesRow, maxOnes};
    }

    private int countOnes(int[] row) {
        int ones = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                ones++;
            }
        }
        return ones;
    }
}
