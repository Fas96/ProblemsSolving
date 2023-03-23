package leetcode.Y2023.weekly.bw99;

import lombok.With;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q6314CountNumberOfPossibleRootNodes {

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], t -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], t -> new ArrayList<>()).add(edge[0]);
        }
        for (int[] guess : guesses) {
            map.put(List.of(guess[0], guess[1]), map.getOrDefault(List.of(guess[0], guess[1]), 0) + 1);
        }
        return rootCount(0, -1, rootCount(0, -1, graph, map), k, graph, map);
    }

    private int rootCount(int u, int from, HashMap<Integer, ArrayList<Integer>> graph,HashMap<List<Integer>, Integer> map) {
        int count = 0;
        for (int v : graph.get(u)) {
            count += v == from ? 0 : rootCount(v, u, graph, map) + map.getOrDefault(List.of(u, v), 0);
        }
        return count;
    }

    private int rootCount(int u, int from, int count, int k, HashMap<Integer, ArrayList<Integer>> graph,
                          HashMap<List<Integer>, Integer> map) {
        int result = count < k ? 0 : 1;
        for (int v : graph.get(u)) {
            result += v == from ? 0
                    : rootCount(v, u, count - map.getOrDefault(List.of(u, v), 0) + map.getOrDefault(List.of(v, u), 0),
                    k, graph, map);
        }
        return result;
    }

    @Test
    public void testRootCount() {
        int[][] edges = {{0,1},{1,2},{1,3},{4,2}};
        int[][] guesses = {{1,3},{0,1},{1,0},{2,4}};
        assertEquals(3, rootCount(edges, guesses, 3));

        int[][] edges1 = {{0,1},{1,2},{2,3},{3,4}};
        int[][] guesses1 = {{1,0},{3,4},{2,1},{3,2}};
        assertEquals(5, rootCount(edges1, guesses1, 1));
    }
}
