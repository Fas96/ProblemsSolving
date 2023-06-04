package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

public class Q983MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
          return mincostTicketsHelper(days, costs, 0, dp);
    }

    private int mincostTicketsHelper(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) return 0;
        if (dp[i] != 0) return dp[i];
        int j = i;
        System.out.println("i = " + i);
        int oneDayPass = costs[0] + mincostTicketsHelper(days, costs, i + 1, dp);
        while (j < days.length && days[j] < days[i] + 7) j++;
        System.out.println("j = " + j);
        int sevenDayPass = costs[1] + mincostTicketsHelper(days, costs, j, dp);
        while (j < days.length && days[j] < days[i] + 30) j++;
        System.out.println("j = " + j);
        int thirtyDayPass = costs[2] + mincostTicketsHelper(days, costs, j, dp);
        dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        return dp[i];
    }


    @Test
    public void test() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }

}
