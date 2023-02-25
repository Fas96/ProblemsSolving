package AATemplates;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class QGraphBFS {
    public int fn(int[][] graph) {
        //TODO: change this to your starting node
        //MANUAL INPUT for the START_NODE
        final int START_NODE = 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(START_NODE);
        seen.add(START_NODE);
        int ans = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            // do some logic
            for (int neighbor: graph[node]) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return ans;
    }
}
