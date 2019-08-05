package HashMap;

import java.util.HashMap;
import java.util.*;

/**
 * @lintcode 526
 * @Time 1 for all operations
 * @Time N + N
 */
public class LoadBalancer {
    int n = 0;
    Map<Integer, Integer> pos;
    List<Integer> array;
    Random rand;
    public LoadBalancer() {
        pos = new HashMap<>();
        array = new ArrayList<>();
        rand = new Random();
    }
    // @param server_id add a new server to the cluster
    // @return void
    public void add(int server_id) {
        if (pos.get(server_id) == null) {
            array.add(server_id);
            pos.put(server_id, this.n);
            this.n++;
        }
    }
    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        if (pos.get(server_id) != null) {
            int lastItem = array.get(n - 1);
            int removeIdx = pos.get(server_id);

            pos.put(lastItem, removeIdx);
            array.set(removeIdx, lastItem);
            pos.remove(server_id);
            array.remove(n - 1);
            this.n--;
        }
    }
    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        return array.get(rand.nextInt(n));
    }
    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer();
        lb.add(1);
        lb.add(2);
        lb.add(3);
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        lb.remove(1);
        System.out.println(lb.pick());
    }
}
