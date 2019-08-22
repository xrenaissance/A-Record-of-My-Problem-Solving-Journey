package TopologicalSort;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/sequence-reconstruction/
 * @Time V + E
 * @Space V + E
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org.length == 0 && seqs.size() == 0) {
            return true;
        }
        if (org.length == 0 || seqs.size() == 0) {
            return false;
        }
        // Initialize graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : seqs) {
            for (int vertex : edge) {
                inDegree.put(vertex, 0);
                graph.putIfAbsent(vertex, new ArrayList<Integer>());
            }
        }
        // build graph
        for (List<Integer> edge : seqs) {
            if (edge.size() > 1) {
                for (int i = 0; i < edge.size() - 1; i++) {
                    int parent = edge.get(i);
                    int child = edge.get(i + 1);
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }
        if (graph.size() != org.length) {
            return false;
        }
        // get all source points
        Queue<Integer> source = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                source.offer(entry.getKey());
            }
        }
        int total = 0;
        // traverse source point
        while (!source.isEmpty()) {
            // check if there were only one source point
            if (source.size() > 1) {
                return false;
            }
            if (org[total] != source.peek()) {
                return false;
            }
            int vertex = source.poll();
            total++;
            for (int child : graph.get(vertex)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    source.offer(child);
                }
            }
        }
        if (total != org.length) {
            return false;
        }
        return true;
    }
}
