package leetcode.Eweekly.w341;

import java.util.*;

public class Q6378MinimizeTheTotalPriceOfTheTrips {

    private Set<Integer>[] graph;
    private int[] count;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        graph = new HashSet[n];
        count = new int[n];
        for (int i = 0;i < n;i ++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int[] trip : trips) {
            int from = trip[0] , to = trip[1];
            // fill count
            backtracking(from , to , - 1 , new ArrayList<>());
        }
        long total = 0;
        for (int i = 0;i < n;i ++) {
            total += count[i] * price[i];
        }
        long[] result = solve(price , 0 , - 1);
        long tmp = Math.max(result[0] , result[1]);
        total -= tmp;
        return (int) total;
    }

    private long[] solve(int[] price , int current , int parent) {
        long notUse = 0 , use = price[current] / 2 * count[current];
        for (int next : graph[current]) {
            if (next != parent) {
                long[] result = solve(price , next , current);
                notUse += Math.max(result[0] , result[1]);
                use += result[0];
            }
        }
        return new long[] {notUse , use};
    }

    private boolean backtracking(int current , int target , int parent , List<Integer> path) {
        path.add(current);
        if (current == target) {
            for (int p : path) {
                count[p] ++;
            }
            path.remove(path.size() - 1);
            return true;
        } else {
            for (int next : graph[current]) {
                if (next != parent) {
                    if (backtracking(next , target , current , path)) {
                        path.remove(path.size() - 1);
                        return true;
                    }
                }
            }
            path.remove(path.size() - 1);
            return false;
        }
    }



}
