package leetcode.Y2023.weekly.w334;

import org.junit.Test;

import java.util.PriorityQueue;

public class Q2577MinimumTimeToVisitACellInAGrid {
    public int minimumTime(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o, p) -> o[2] - p[2]);
        for (q.offer(new int[3]); (grid[0][1] < 2 || grid[1][0] < 2) && !q.isEmpty(); q.poll()) {
            if (q.peek()[0] == grid.length - 1 && q.peek()[1] == grid[0].length - 1) {
                return q.peek()[2];
            } else if (grid[q.peek()[0]][q.peek()[1]] >= 0) {
                grid[q.peek()[0]][q.peek()[1]] = -1;
                for (int[] i : new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } }) {
                    if (q.peek()[0] + i[0] >= 0 && q.peek()[0] + i[0] < grid.length && q.peek()[1] + i[1] >= 0
                            && q.peek()[1] + i[1] < grid[0].length) {
                        q.offer(new int[] { q.peek()[0] + i[0], q.peek()[1] + i[1], q.peek()[2] + 1
                                + Math.max(0, (grid[q.peek()[0] + i[0]][q.peek()[1] + i[1]] - q.peek()[2]) / 2 * 2) });
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
       //[[0,1,3,2],[5,1,2,5],[4,3,8,6]]
        int[][] grid = {{0,1,3,2},{5,1,2,5},{4,3,8,6}};
        int answer = minimumTime(grid);
        System.out.println(answer);
    }
}
