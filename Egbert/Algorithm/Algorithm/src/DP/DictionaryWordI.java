package DP;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Egbert Li
 * @date 26/04/2019
 * Time: N ^ 2 N = input.length
 * Space: O(M + N)
 */
public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        Set<String> setDict = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && setDict.contains(input.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }
    private Set<String> toSet(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }
}
