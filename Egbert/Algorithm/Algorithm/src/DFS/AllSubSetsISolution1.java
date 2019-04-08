package DFS;

/**
 * @author Egbert Li
 * @date 8/4/2019
 * Time complexity 2 ^ n
 * Space compleixty O(height)
 */
public class AllSubSetsISolution1 {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sol = new StringBuilder();
        subSets(arraySet, 0, sol, result);
        return result;
    }
    private void subSets(char[] arraySet,
                         int index,
                         StringBuilder sol,
                         List<String> result) {
        if (index == arraySet.length) {
            result.add(sol.toString());
            return;
        }
        // don't add letter at current index
        subSets(arraySet, index + 1, sol, result);
        subSets(arraySet, index + 1, sol.append(arraySet[index]), result);
        sol.deleteCharAt(sol.length() - 1);
    }
}
