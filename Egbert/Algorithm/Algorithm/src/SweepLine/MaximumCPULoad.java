package SweepLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5660980839186432
 * @Time NlogN
 * @Space N
 */
public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
        if (jobs == null || jobs.size() == 0) {
            return 0;
        }
        List<Load> loadList = new ArrayList<>();
        for (Job j : jobs) {
            loadList.add(new Load(j.start, j.cpuLoad));
            loadList.add(new Load(j.end, -j.cpuLoad));
        }
        Collections.sort(loadList, (l1, l2) -> {
            int diff= l1.time - l2.time;
            if (diff == 0) {
               diff = l1.load - l2.load;
            }
            return diff;
        });
        int maxLoad = 0;
        int currLoad = 0;
        for (Load l : loadList) {
            currLoad += l.load;
            maxLoad = Math.max(currLoad, maxLoad);
        }
        return maxLoad;
    }
    public static class Load {
        int time;
        int load;
        public Load(int time, int load) {
            this.time = time;
            this.load = load;
        }
    }
    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
