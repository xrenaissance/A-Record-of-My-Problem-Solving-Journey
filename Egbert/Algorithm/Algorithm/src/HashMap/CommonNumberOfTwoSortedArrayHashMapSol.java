package HashMap;
import java.util.*;

/**
 * @author Egbert Li
 * @date 11/04/2019
 * Time: O(N)
 * Space: O(N)
 */
public class CommonNumberOfTwoSortedArrayHashMapSol {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        if (A == null && B == null) {
            return result;
        }
        if (A == null) {
            return result;
        } else if (B == null) {
            return result;
        }
        HashMap<Integer, Integer> record = new HashMap<>();
        for (Integer elem : A) {
            if (record.containsKey(elem)) {
                record.put(elem, record.get(elem) + 1);
            } else {
                record.put(elem, 1);
            }
        }
        for (Integer elem : B) {
            if (record.containsKey(elem) && record.get(elem) >= 1) {
                result.add(elem);
                record.put(elem, record.get(elem) - 1);
            }
        }
        return result;
    }
}
