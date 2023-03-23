package leetcode.Y2023.weekly.bw99;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class Q6313CountWaysToGroupOverlappingRanges {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (o, p) -> o[0] - p[0]);
        int count = 1;
        for (int i = 0, j = -1; i < ranges.length; j = Math.max(j, ranges[i++][1])) {
            count = ranges[i][0] > j ? count * 2 % 1000000007 : count;
        }
        return count;
    }

    @Test
    public void testCountWays(){
        assertEquals(2, countWays(new int[][]{{6,10},{5,15}}));
        assertEquals(4, countWays(new int[][]{{1,3},{10,20},{2,5},{4,8}}));
        assertEquals(2, countWays(new int[][]{{34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}}));
    }
}
