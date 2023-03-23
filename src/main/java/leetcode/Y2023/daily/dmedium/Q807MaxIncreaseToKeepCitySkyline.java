package leetcode.Y2023.daily.dmedium;

import java.util.Arrays;

public class Q807MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int M = grid.length;
        int N= grid[0].length;
        long differences=0;
        int[] keepMaxOfROW = new int[grid.length];
        int[] keepMaxOfCOL = new int[grid[0].length];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                keepMaxOfROW[i] = Math.max(keepMaxOfROW[i], grid[i][j]);
                keepMaxOfCOL[j] = Math.max(keepMaxOfCOL[j], grid[i][j]);
            }
        }

        print2DArray(grid);
        System.out.println(Arrays.toString(keepMaxOfROW));

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                differences += Math.min(keepMaxOfROW[i], keepMaxOfCOL[j]) - grid[i][j];
                grid[i][j] = Math.min(keepMaxOfROW[i], keepMaxOfCOL[j]-grid[i][j]);
            }
        }
        print2DArray(grid);
        System.out.println(Arrays.toString(keepMaxOfROW));
        return (int) differences;
    }
    private void print2DArray(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}
