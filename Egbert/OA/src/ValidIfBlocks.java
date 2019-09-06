import java.util.List;
import java.util.ArrayList;
public class ValidIfBlocks {
    public static List<String> validIf(int n) {
        List<String> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        StringBuilder sol = new StringBuilder();
        int[] count = new int[1];
        validIf(n, 0, 0, count, sol, result);
        return result;
    }
    private static void validIf(int n, int left, int right, int[] count,
                         StringBuilder sol, List<String> result) {
        if (left == n && right == n) {
            sol.append("\n");
            result.add(sol.toString());
            return;
        }
        if (left < n) {
            // add if { \n
            for (int i = 0; i < count[0]; i++) {
                sol.append(" ");
            }
            sol.append("if {\n\n");
            count[0] += 1;
            validIf(n, left + 1, right, count, sol, result);
            sol.deleteCharAt(sol.length() - 1);
            for (int i = 0; i < count[0]; i++) {
                sol.deleteCharAt(sol.length() - 1);
            }
            count[0]--;
        }
        if (left > right) {
            for (int i = 0; i < count[0]; i++) {
                sol.append(" ");
            }
            // count[0] += 1;
            sol.append("}\n\n");
            count[0] -= 1;
            validIf(n, left, right + 1, count, sol, result);
            sol.deleteCharAt(sol.length() - 1);
            for (int i = 0; i < count[0]; i++) {
                sol.deleteCharAt(sol.length() - 1);
            }
            count[0]--;
        }
    }
}
