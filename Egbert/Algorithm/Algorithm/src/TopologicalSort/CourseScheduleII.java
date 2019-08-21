package TopologicalSort;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/course-schedule-ii/
 * @param V number of course
 * @param E number of prerequisites
 * @Time V + E
 * @Space V + E
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        // handle corner course
        if (prerequisites.length == 0 && numCourses > 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        // Graph initialization
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // build graph
        for (int[] pre : prerequisites) {
            int parent = pre[1];
            int child = pre[0];
            inDegrees.put(child, inDegrees.get(child) + 1);
            graph.get(parent).add(child);
        }
        // get pre couses
        Queue<Integer> pres = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                pres.offer(entry.getKey());
            }
        }
        int index = 0;
        // BFS travese each pre courses, then finished, degree -1, if = 0, then new pre is formed
        while (!pres.isEmpty()) {
            int pre = pres.poll();
            result[index++] = pre;
            for (int child : graph.get(pre)) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    pres.offer(child);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
