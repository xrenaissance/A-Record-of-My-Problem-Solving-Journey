package DFS;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Egbert Li
 * @date 18/05/2019
 * Time: O(n)
 * Space: O(n)
 */
public class DeepCopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }
    private void DFS(GraphNode node, Map<GraphNode, GraphNode> map) {
        GraphNode copiedNode = map.get(node);
        for (GraphNode nei : node.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new GraphNode(nei.key));
                DFS(nei, map);
            }
            copiedNode.neighbors.add(map.get(nei));
        }
    }
}
