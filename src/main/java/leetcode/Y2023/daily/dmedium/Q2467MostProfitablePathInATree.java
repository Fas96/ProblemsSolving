package leetcode.Y2023.daily.dmedium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q2467MostProfitablePathInATree {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int[] pathTakenByBobGettingToZero = new int[graph.size()];
        bobMovesToZero(graph, bob, -1, 1, pathTakenByBobGettingToZero);
        return aliceTraverseForMaxPath(graph, 0, -1, 1, pathTakenByBobGettingToZero, amount);
    }

    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new LinkedList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new LinkedList<>()).add(edge[0]);
        }
        return graph;
    }

    boolean bobMovesToZero(Map<Integer, List<Integer>> graph, int bob, int prev, int time, int[] pathTakenByBobGettingToZero) {
        pathTakenByBobGettingToZero[bob] = time;
        if (bob == 0) { return true; }
        for (int next : graph.get(bob)) {
            if (next == prev) { continue; }
            if (bobMovesToZero(graph, next, bob, time + 1, pathTakenByBobGettingToZero)) {
                return true;
            }
        }
        pathTakenByBobGettingToZero[bob] = 0;
        return false;
    }

    int aliceTraverseForMaxPath(Map<Integer, List<Integer>> graph, int alice, int prev, int time, int[] pathTakenByBobGettingToZero, int[] amount) {
        int max = Integer.MIN_VALUE;
        for (int next : graph.get(alice)) {
            if (next == prev) { continue; }
            max = Math.max(max, aliceTraverseForMaxPath(graph, next, alice, time + 1, pathTakenByBobGettingToZero, amount));
        }

        int reward = (time < pathTakenByBobGettingToZero[alice] || pathTakenByBobGettingToZero[alice] == 0)
                ? amount[alice]
                : time == pathTakenByBobGettingToZero[alice]
                ? amount[alice] / 2
                : 0;
        return (max == Integer.MIN_VALUE ? 0 : max) + reward;
    }
}
