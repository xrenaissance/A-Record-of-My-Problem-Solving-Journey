package Facebook;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
/**
 * @leetcode
 * @Time number of integer in list
 * @Space average length of the list
 */
public class NestedListWeightSum {
    // Solution 1: level order traversal
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int depth = 1;
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger elem = queue.poll();
                if (elem.isInteger()) {
                    sum += elem.getInteger() * depth;
                } else {
                    queue.addAll(elem.getList());
                }
            }

            depth++;
        }

        return sum;
    }

    // Solution2: still dfs, but more elegant code
    public int depthSumSolution2(List<NestedInteger> nestedList) {
        return update2(nestedList, 1);
    }

    private int update2(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                sum += element.getInteger() * depth;
            } else {
                sum += update2(element.getList(), depth + 1);
            }
        }

        return sum;
    }

    // Solution 3: my initial Solution
    public int depthSumMySolution(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int[] depth = new int[] {1};
        int[] sum = new int[1];
        for (NestedInteger nestedInt : nestedList) {
            update(nestedInt, depth, sum);
        }

        return sum[0];
    }

    private void update(NestedInteger nestedInt,
                        int[] depth, int[] sum) {
        if (nestedInt.isInteger()) {
            sum[0] += nestedInt.getInteger() * depth[0];
        } else {
            depth[0]++;
            for (NestedInteger element : nestedInt.getList()) {
                update(element, depth, sum);
            }
            depth[0]--;
        }
    }
}
