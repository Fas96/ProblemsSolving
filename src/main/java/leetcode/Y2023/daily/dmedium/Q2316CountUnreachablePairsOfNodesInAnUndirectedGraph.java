package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q2316CountUnreachablePairsOfNodesInAnUndirectedGraph {
    int size=0;
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        List<Integer> eachComponentSize = new ArrayList<>();
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                size = 0;
                dfs(map, i, visited);
                eachComponentSize.add(size);
            }
        }

        long ans = 0;
        long sum = n;
        for (int i = 0; i < eachComponentSize.size(); i++) {
            sum -= eachComponentSize.get(i);
            ans += eachComponentSize.get(i) * sum;
        }
        return ans;
    }

    private void dfs(HashMap<Integer, List<Integer>> map, int i, boolean[] visited) {
        visited[i] = true;
        size++;
        for (int j : map.get(i)) {
            if (!visited[j]) dfs(map, j, visited);
        }
    }


    @Test
    public void test() {
        assertEquals(0, countPairs(3, Ps.intArray("[[0,1],[0,2],[1,2]]")));
        assertEquals(14, countPairs(7, Ps.intArray("[[0,2],[0,5],[2,4],[1,6],[5,4]]")));
    }
}
