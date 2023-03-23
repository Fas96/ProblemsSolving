package leetcode.Y2023.weekly.w337;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Q6322CheckKnightTourConfiguration {
    static int[] DR = new int[] {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] DC = new int[] {2, -2, 1, -1, 2, -2, 1, -1};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int r = 0, c = 0;
        for (int i = 1; i < n * n; ++i) {
            boolean found = false;
            for (int d = 0; d < 8; ++d) {
                int nr = r + DR[d];
                int nc = c + DC[d];
                if (nr < 0 || nc < 0 || nr > n - 1 || nc > n - 1) continue;
                if (grid[nr][nc] == i) {
                    r = nr;
                    c = nc;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
    @Test
    public void test() {
        int[][] grid = Ps.intArray("[[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]");
        assertEquals(true, checkValidGrid(grid));
        grid=Ps.intArray("[[0,3,6],[5,8,1],[2,7,4]]");
        assertEquals(false, checkValidGrid(grid));

    }
}
