package Subsets;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/binary-watch/
 * @Time 12 * 59
 * @Space 5
 */
public class BinaryWatch {
    // naive dfs
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if (num < 0) {
            return result;
        }
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sol.append(i).append(':');
            int start = sol.length();
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    if (j < 10) {
                        sol.append(0).append(j);
                    } else {
                        sol.append(j);
                    }
                    result.add(sol.toString());
                    sol.setLength(start);
                }
            }
            sol.setLength(0);
        }
        return result;
    }
}
