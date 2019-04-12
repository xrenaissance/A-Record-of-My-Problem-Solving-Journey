package HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Egbert Li
 * @date 11/04/2019
 * Time: O(n + m)
 * Space: O(1)
 */
public class CommonNumberOfTwoSortedArrayTwoPointerSol {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        if (A == null && B == null) {
            return result;
        } else if (A == null || B == null) {
            return result;
        }
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (B.get(j) < A.get(i)) {
                j ++;
            } else {
                result.add(A.get(i));
                i++;
                j++;
            }
        }
        return result;
    }
}
