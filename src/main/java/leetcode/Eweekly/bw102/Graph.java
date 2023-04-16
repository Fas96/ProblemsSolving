package leetcode.Eweekly.bw102;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph {
    private long[][] adjMatrix;

    public Graph(int n, int[][] edges) {
        adjMatrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adjMatrix[i], -1);
        }
        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]] = edge[2];
        }
    }

    public void addEdge(int[] edge) {
        adjMatrix[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        int n = adjMatrix.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        pq.offer(node1);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (u == node2) {
                return (int)dist[u];
            }
            for (int v = 0; v < n; v++) {
                if (adjMatrix[u][v] != -1) {
                    long alt = dist[u] + adjMatrix[u][v];
                    if (alt < dist[v]) {
                        dist[v] = (int) alt;
                        pq.offer(v);
                    }
                }
            }
        }
        return -1;
    }
}
