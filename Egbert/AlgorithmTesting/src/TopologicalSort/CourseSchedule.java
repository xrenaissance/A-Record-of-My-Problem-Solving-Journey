package TopologicalSort;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/course-schedule/
 * @Time V + E E = number of courses, E = total number of prerequisites
 * @Space V + E
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 ||
                prerequisites[0].length == 0) {
            return true;
        }
        // Graph Initialization
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // Building Graph and inDegrees records
        for (int[] edge : prerequisites) {
            int parent = edge[0];
            int child = edge[1];
            inDegrees.put(child, inDegrees.get(child) + 1);
            graph.get(parent).add(child);
        }
        // c. Get first level of source vertexs and put them in Queue
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }
        // BFS, get source point, and decrement by 1 for its children, then if 0, it becomes new source point
        int total = 0;
        while (!sources.isEmpty()) {
            total++;
            int parent = sources.poll();
            for (int child : graph.get(parent)) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }
        // if ordering totals doest have all of courses
        if (total != numCourses) {
            return false;
        }
        return true;
    }
}
