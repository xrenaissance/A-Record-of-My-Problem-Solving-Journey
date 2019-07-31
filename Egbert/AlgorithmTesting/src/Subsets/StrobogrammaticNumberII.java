package Subsets;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/strobogrammatic-number-ii/
 * @Time 5 ^ (n/2)
 * @Space O 5 + n
 */
public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        List<String> result = new ArrayList<>();
        char[] sol = new char[n];
        dfs(0, n - 1, sol, result, map);
        return result;
    }
    private void dfs(int left, int right, char[] sol,
                     List<String> result,
                     Map<Character, Character> map) {
        if (left >= right) {
            if (left == right) {
                sol[left] = '0';
                result.add(new String(sol));
                sol[left] = '1';
                result.add(new String(sol));
                sol[left] = '8';
                result.add(new String(sol));
            } else {
                result.add(new String(sol));
            }
            return;
        }
        for (Character ch : map.keySet()) {
            if (left == 0 && ch == '0') {
                continue;
            }
            sol[left] = ch;
            sol[right] = map.get(ch);
            dfs(left + 1, right - 1, sol, result, map);
        }
    }
}
