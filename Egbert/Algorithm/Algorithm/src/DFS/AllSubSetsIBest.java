package DFS;

/**
 * @author Egbert Li
 * @date 9/4/2019
 * Time complexity: 2 ^ n
 * Space complexity: O height
 */
public class AllSubSetsIBest {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        StringBuilder sol = new StringBuilder();
        char[] arraySet = set.toCharArray();
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

        // add current letter
        sol.append(arraySet[index]);
        subSets(arraySet, index + 1, sol, result);
        sol.deleteCharAt(sol.length() - 1);

        // don't add current letter
        subSets(arraySet, index + 1, sol, result);
    }
}
