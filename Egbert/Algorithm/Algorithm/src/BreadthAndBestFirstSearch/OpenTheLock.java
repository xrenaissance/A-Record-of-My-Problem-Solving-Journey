package BreadthAndBestFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode https://leetcode.com/problems/open-the-lock/
 * @Time 10 ^ 4
 * @Space num of dead + 2 ^ 4
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (target.equals(start)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String str : deadends) {
            dead.add(str);
        }
        if (dead.contains(start)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                for (int k = 0; k < 4; k++) {
                    String next = state.substring(0, k) +
                            (state.charAt(k) - '0' - 1 + 10) % 10 +
                            state.substring(k + 1);
                    if (target.equals(next)) {
                        return dist;
                    }
                    if (!visited.contains(next) && !dead.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }

                    next = state.substring(0, k) +
                            (state.charAt(k) - '0' + 1 + 10) % 10 +
                            state.substring(k + 1);
                    if (target.equals(next)) {
                        return dist;
                    }
                    if (!visited.contains(next) && !dead.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
