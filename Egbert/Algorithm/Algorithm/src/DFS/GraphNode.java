package DFS;
import java.util.List;
import java.util.ArrayList;
public class GraphNode {
   public int key;
   public List<GraphNode> neighbors;
   public GraphNode(int key) {
       this.key = key;
       this.neighbors = new ArrayList<GraphNode>();
   }
}
