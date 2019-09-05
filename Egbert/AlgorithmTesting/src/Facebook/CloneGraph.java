package Facebook;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
/**
 * @leetcode https://leetcode.com/problems/clone-graph/
 * @Time N number of nodes
 * @Space average length of neighbors
 */
public class CloneGraph {
    // solution1: DFS
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

    // Solution2: BFS
    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }

                map.get(currNode.val).neighbors.add(map.get(neighbor.val));
            }
        }

        return map.get(node.val);
    }
}
