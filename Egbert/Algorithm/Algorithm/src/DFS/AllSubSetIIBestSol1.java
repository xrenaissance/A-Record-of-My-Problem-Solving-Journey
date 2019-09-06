package DFS;
import java.util.*;
public class AllSubSetIIBestSol1 {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder currLayer = new StringBuilder();
        subSets(array, 0, currLayer, result);
        return result;
    }
    private void subSets(char[] array, int index,
                         StringBuilder currLayer,
                         List<String> result) {
        if (index == array.length) {
            result.add(currLayer.toString());
            return;
        }
        Set<Character> visited = new HashSet<>();
        // add array[index]
        currLayer.append(array[index]);
        subSets(array, index + 1, currLayer, result);
        currLayer.deleteCharAt(currLayer.length() - 1);
        // doesn't add array[index]
        // skill all the consecutive and duplicate elements
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        subSets(array, index + 1, currLayer, result);
    }
}
