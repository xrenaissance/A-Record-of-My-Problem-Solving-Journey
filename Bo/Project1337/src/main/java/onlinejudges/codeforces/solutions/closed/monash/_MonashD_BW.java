package main.java.onlinejudges.codeforces.solutions.closed.monash;

import java.util.*;

/**
 * BW's FoldFulkerson DFS implementation
 * Fails at test something like #12 due to its performance
 */
public class _MonashD_BW {

    // Model
    static Scanner sc = new Scanner(System.in);

    static int vertexCount;
    static int edgeCount;

    static int sourceId;
    static int targetId;

    static Map<Integer, Integer>[] ajlists;

    static List<Integer> path;
    static boolean pathFound;

    static int maxFlow;

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {

        // Init line 1 + 2
        vertexCount = sc.nextInt();
        edgeCount = sc.nextInt();
        sc.nextLine();

        sourceId = sc.nextInt() - 1;
        targetId = sc.nextInt() - 1;
        sc.nextLine();

        // Init Adjacent Lists
        ajlists = new HashMap[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            ajlists[i] = new HashMap<Integer, Integer>();
        }

        // Read Edges
        for (int i = 0; i < edgeCount; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int capacity = sc.nextInt();
            sc.nextLine();
            if (ajlists[from].get(to) == null)
                ajlists[from].put(to, capacity);
            else
                ajlists[from].put(to, ajlists[from].get(to) + capacity);
        }

        // Perform DFS path checking + argumenting residual network
        do {
            path = new ArrayList<Integer>();
            pathFound = false;
            path.add(0, sourceId);

            findPath(path);

            if (pathFound) {
                argumentingResidualNetwork(path);
            }

        } while (pathFound);

        System.out.println(maxFlow);
    }

    public static void argumentingResidualNetwork(List<Integer> path) {

        int pathFlow = getPathFlow(path);

        for (int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            // deduct occupied forward path flow
            ajlists[from].put(to, ajlists[from].get(to) - pathFlow);

            if (ajlists[to].get(from) == null) {
                ajlists[to].put(from, pathFlow);
            } else {
                ajlists[to].put(from, ajlists[to].get(from) + pathFlow);
            }
        }
    }

    // DFS
    public static void findPath(List<Integer> path) {

        int currentVertex = path.get(path.size() - 1);

        // Go to next vertex
        for (Map.Entry<Integer, Integer> entry : ajlists[currentVertex].entrySet()) {

            // Find next hop
            if (entry.getValue() > 0 && !path.contains(entry.getKey())) {

                path.add(entry.getKey());

                // Reached target
                if (path.size() > 1 && path.get(path.size() - 1) == targetId) {
                    maxFlow += getPathFlow(path);
                    pathFound = true;
                    return;
                } else {
                    findPath(path);
                }

                if (!pathFound) {
                    path.remove(path.size() - 1);
                } else {
                    return;
                }

            }
        }

        return;
    }

    public static int getPathFlow(List<Integer> path) {
        int pathFlow = ajlists[path.get(0)].get(path.get(1));

        for (int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            int capacity = ajlists[from].get(to);
            pathFlow = pathFlow > capacity ? capacity : pathFlow;
        }

        return pathFlow;
    }

    public static void showInfo() {
        System.out.println("vertexCount: " + vertexCount);
        System.out.println("edgeCount: " + edgeCount);
        System.out.println("sourceId: " + sourceId);
        System.out.println("targetId: " + targetId + "\n");
    }

    public static void showGraph() {
        int i = 0;
        for (Map<Integer, Integer> list : ajlists) {
            for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
                System.out.println("Edge: from [" + i + "] to [" + entry.getKey() + "] capacity [" + entry.getValue() + "]");
            }
            i++;
        }
    }

}
