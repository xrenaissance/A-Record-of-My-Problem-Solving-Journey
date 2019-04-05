package BreadthAndBestFirstSearch;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author Egbert Li
 * @date 6/04/2019
 * Time complexiy: O(n)
 * Space complexity O(n)
 */
public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null || graph.size() == 0) {
            return true;
        }
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        // if graph is undirected graph
        for (GraphNode node : graph) {
            // if in same set, it means it can be conneted, so no
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        // already visited, this node is safe
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else {
                    if (visited.get(nei) != neiGroup) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
}
