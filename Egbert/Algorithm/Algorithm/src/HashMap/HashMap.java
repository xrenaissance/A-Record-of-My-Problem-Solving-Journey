package HashMap;
import java.util.List;
import java.util.ArrayList;
public class HashMap {
    public List<Node> entry;
    public HashMap() {
        entry = new ArrayList<>();
    }
    public class Node {
        String key;
        Integer value;
        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    public void put(String key, Integer value) {
        int contains = containsKey(key);
        if (contains == -1) {
            entry.add(new Node(key, value));
        } else {
            entry.get(contains).value = value;
        }
    }
    public Integer get(String key) {
       if (containsKey(key) == -1)  {
           return null;
       } else {
          return entry.get(containsKey(key)).value;
       }
    }
    public int containsKey(String key) {
        for (Node node : entry) {
            if (entry.key.equals(key)) {
                return entry.indexOf(node);
            }
        }
        return -1;
    }
}
