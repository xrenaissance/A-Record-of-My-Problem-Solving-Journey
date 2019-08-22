package TopologicalSort;
import java.util.*;

/**
 * @leetcode https://www.educative.io/collection/page/5668639101419520/5671464854355968/4994209155121152
 * @param V number of Course
 * @param E number of prerequisites
 * if we don't havfe any prerequisiteds, all combinations of tasks can
 * prepresent a topological sort,so it will be n * n-1 * n-2 *..*1 = N!
 * @Time V! * E
 * @Space N! * E
 */
public class AllTaksShedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0) {
            return;
        }
        // a. Initialization the graph
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // b. Build the graph
        for (int[] p : prerequisites) {
            int parent = p[0];
            int child = p[1];
            inDegrees.put(child, inDegrees.get(child) + 1);
            graph.get(parent).add(child);
        }
        // c. Find all source points
        Queue<Integer> source = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                source.offer(entry.getKey());
            }
        }
        // d. DFS print all
        printAll(graph, inDegrees, source, sortedOrder);
    }
    private static void printAll(Map<Integer, List<Integer>> map,
                                 Map<Integer,Integer> inDegrees,
                                 Queue<Integer> source,
                                 List<Integer> sortedOrder) {
        if (!source.isEmpty()) {
            for (Integer s : source) {
                sortedOrder.add(s);
                Queue<Integer> nextSource = cloneQueue(source);
                nextSource.remove(s);
                // List<Integer> children = map.get(s);
                for (int child : map.get(s)) {
                    inDegrees.put(child, inDegrees.get(child) - 1);
                    if (inDegrees.get(child) == 0) {
                        nextSource.offer(child);
                    }
                }

                // recursive call to print other ordering from remaining
                // and new source pointers
                printAll(map, inDegrees, nextSource, sortedOrder);

                // backtrack
                sortedOrder.remove(s);
                for (int child : map.get(s)) {
                    inDegrees.put(child, inDegrees.get(child) + 1);
                }
            }
        }
        // if sorted doest contains all tasks,then cyclic dependency
        // between tasks or we have not processed all tasks in this
        // recursive call
        if (sortedOrder.size() == inDegrees.size()) {
            System.out.println(sortedOrder);
        }
    }
    private static Queue<Integer> cloneQueue(Queue<Integer> source) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer s: source) {
            queue.offer(s);
        }
        return queue;
    }
    public static void main(String[] args) {
        AllTaksShedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaksShedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaksShedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}
