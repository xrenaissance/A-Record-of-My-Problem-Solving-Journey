package TopologicalSort;
import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * @param  V = N
 * @param E = edges.length
 * @Time V + E
 * @Space V + E
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        if (n == 1) {
            result.add(0);
            return result;
        }
        // Graph Initialization
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        // Build Graph
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            inDegree.put(parent, inDegree.get(parent) + 1);
            inDegree.put(child, inDegree.get(child) + 1);
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        // push all leves to queue, leves means that indegree = 1
        Queue<Integer> leves = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 1) {
                leves.offer(entry.getKey());
            }
        }
        // leves will never be root, so finish the leves first, then we know
        // the rest nodes have at least 2 nodes connected with other nodes,
        // then remove edge, the child's degree - 1, if degree = 1, then new leves are formed
        // until we has <= 2 nodes in queue, we know they are in same level
        // so remove nodes level by level
        while (n > 2) {
            int size = leves.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int leaf = leves.poll();
                for (Integer child : graph.get(leaf)) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 1) {
                        leves.offer(child);
                    }
                }
            }
        }
        result.addAll(leves);
        return result;
    }
}
