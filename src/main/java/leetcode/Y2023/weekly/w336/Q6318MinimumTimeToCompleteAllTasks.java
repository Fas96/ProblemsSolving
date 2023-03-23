package leetcode.Y2023.weekly.w336;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class Q6318MinimumTimeToCompleteAllTasks {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1])); // sort tasks by end time
        int n = tasks.length;
        int[] dp = new int[n];
        dp[0] = tasks[0][2]; // base case
        for (int i = 1; i < n; i++) {
            int duration = tasks[i][2];
            int prev = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (tasks[j][1] <= tasks[i][0]) { // check if the jth task can be completed before the ith task starts
                    prev = j;
                    break;
                }
            }
            if (prev == -1) {
                dp[i] = Math.max(duration, dp[i - 1]); // if no task can be completed before the ith task starts, turn on the computer for duration time
            } else {
                dp[i] = Math.max(duration + dp[prev], dp[i - 1]); // if the jth task can be completed before the ith task starts, turn on the computer for the duration of the ith task plus the time to complete the jth task
            }
        }
        return dp[n - 1];
    }
    @Test
    public void findMinimumTimeTest(){
        assertEquals(2,findMinimumTime(new int[][]{{2,3,1},{4,5,1},{1,5,2}}));
        assertEquals(4,findMinimumTime(new int[][]{{1,3,2},{2,5,3},{5,6,2}}));
        assertEquals(7,findMinimumTime(new int[][]{{14,20,5},{2,18,7},{6,14,1},{3,16,3}}));
    }

}
