package Facebook;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @leetcode https://leetcode.com/problems/clone-graph/
 * @Time N number of nodes
 * @Space average length of neighbors
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node currNode, Map<Integer, Node> map) {
        if (currNode == null) {
            return null;
        }

        if (map.containsKey(currNode.val)) {
            return map.get(currNode.val);
        }

        Node cloneNode = new Node(currNode.val, new ArrayList<>());
        map.put(currNode.val, cloneNode);

        for (Node neighbor : currNode.neighbors) {
            cloneNode.neighbors.add(clone(neighbor, map));
        }

        return cloneNode;
    }
}
