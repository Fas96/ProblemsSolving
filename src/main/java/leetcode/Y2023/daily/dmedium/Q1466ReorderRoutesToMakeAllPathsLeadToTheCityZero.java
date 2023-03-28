package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            //add the edge from parent to child
            graph[connection[0]].add(connection[1]);
            //change the direction of the edge from child to parent
            graph[connection[1]].add(-connection[0]);
        }
        return dfs(graph, 0, new boolean[n]);
    }

    private int dfs(List<Integer>[] graph, int from, boolean[] booleans) {
        booleans[from] = true;
        int ans = 0;
        for (int to : graph[from]) {
            if (booleans[Math.abs(to)]) continue;
            ans += to > 0 ? 1 : 0;
            ans += dfs(graph, Math.abs(to), booleans);
        }
        return ans;
    }


    public int minReorderUF(int n, int[][] connections) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Queue<int[]> queue = new LinkedList<>();
        for (int[] c : connections) queue.offer(c);

        parent[0] = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int p1 = find(parent, cur[0]);
            int p2 = find(parent, cur[1]);
            if (p1 == 0 && p2 != 0) {
                res++;
                parent[cur[1]] = 0;
            } else if (p1 != 0 && p2 != 0) {
                queue.offer(cur);
            } else {
                parent[cur[0]] = 0;
                parent[cur[1]] = 0;
            }
        }
        return res;
     }

    public int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }
    public int minReorderCC(int n, int[][] connections) {
        Map<Integer, City> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new City(i));
        }
        for (int[] connection : connections) {
            City from = map.get(connection[0]);
            City to = map.get(connection[1]);
            from.addRoad(to);
        }
        City capital = map.get(0);
        int answer = capital.countReverse();
        return answer;
    }

    class City {
        public City(int num) {
            this.num = num;
        }

        int num;
        Set<City> out = new HashSet<>();
        Set<City> in = new HashSet<>();

        public void addRoad(City to) {
            this.out.add(to);
            to.in.add(this);
        }

        public int countReverse() {
            int cnt = out.size();
            for (City city : out) {
                city.in.remove(this);
                cnt += city.countReverse();
            }
            for (City city : in) {
                city.out.remove(this);
                cnt += city.countReverse();
            }
            in.addAll(out);
            out.clear();
            return cnt;
        }
    }

    @Test
    public void test() {
//        int[][] connections = Ps.intArray("[[0,1],[1,3],[2,3],[4,0],[4,5]]");
        int[][] connectionsUF = Ps.intArray("[[0,1],[1,3],[2,3],[4,0],[4,5]]");
//        assertEquals(3, minReorder(6, connections));
//        connections=Ps.intArray("[[1,0],[2,0]]");

//        assertEquals(0, minReorder(3, connections));

        assertEquals(3, minReorderUF(6, connectionsUF));
        connectionsUF=Ps.intArray("[[1,0],[2,0]]");
        assertEquals(0, minReorderUF(3, connectionsUF));
    }
}
