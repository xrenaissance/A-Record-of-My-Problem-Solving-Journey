package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/task-scheduler/
 * @date 18/7/2019
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6209895416201216
 * @Ttime N log N
 * @Space D + N   D = number of distinct tasks, N is total number
 */
//The expression can be simplified into
//        Math.max(tasks.length,maxCount+(n+1)*(max-1)),
//        which means normal case
//        it's (n+1)*(max-1)+maxCount with idling but if
//        task length is long enough, you don't have to wait and it's just tasks.length.
//
//        More specifically:
//        (n+1) is the length of each idling iteration.
//        (max-1) is the number of idling iterations
//        maxCount is the length of last iteration to finish out remaining tasks
public class TaskScheduler {
    public static int scheduleTasks(char[] tasks, int k) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        Map<Character, Integer> chFreqMap = createMap(tasks);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue()
        );
        int timeInterval = 0;
        // N log N
        maxHeap.addAll(chFreqMap.entrySet());
        // N log N
        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> buffer = new ArrayList<>();
            int numOfTasksToProc = k + 1;
            while (!maxHeap.isEmpty() && numOfTasksToProc > 0) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                timeInterval++;
                if (entry.getValue() > 1) {
                    entry.setValue(entry.getValue() - 1);
                    buffer.add(entry);
                }
                numOfTasksToProc--;
            }
            maxHeap.addAll(buffer);
            if (!maxHeap.isEmpty()) {
                timeInterval += numOfTasksToProc;
            }
        }
        return timeInterval;
    }
    private static Map<Character, Integer> createMap(char[] tasks) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));

        tasks = new char[] { 'a', 'a', 'a', 'b', 'b', 'b' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));
    }
}
