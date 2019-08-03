package Sort;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/reorder-log-files/
 * @Time nlogn merger sort
 * @Time n
 */
public class ReorderLogFiles {
    public static String[] logSort(String[] logs) {
        if (logs == null || logs.length == 0) {
            return new String[0];
        }
        Arrays.sort(logs, (s1, s2) -> {
            int idx1 = s1.indexOf(' ');
            int idx2 = s2.indexOf(' ');
            char s1fc = s1.charAt(idx1 + 1);
            char s2fc = s2.charAt(idx2 + 1);
            if (s1fc <= '9') {
                if (s2fc <= '9') {
                    return 0;
                } else {
                    return 1;
                }
            }
            if (s2fc <= '9') {
                return -1;
            }
            int preCompute = s1.substring(idx1 + 1).compareTo(s2.substring(idx2 + 1));
            if (preCompute == 0) {
                return s1.substring(0, idx1).
                       compareTo(s2.substring(0, idx2));
            }
            return preCompute;
        });
        return logs;
    }
    public static void main(String[] args) {
        String[] logs = new String[] {"zo4 4 7",
                "a100 Act zoo",
                "a1 9 2 3 1",
                "g9 act car"};
        ReorderLogFiles.logSort(logs);
        Arrays.stream(logs).forEach(System.out :: println);
    }
}
