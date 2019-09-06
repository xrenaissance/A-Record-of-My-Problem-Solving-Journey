import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class GetMinimumMoves {
    public static int getMinimumMoves(List<Integer> identification) {
        if (identification == null || identification.size() <= 1) {
            return 0;
        }
        List<Integer> copy = new ArrayList<>(identification);
        Collections.sort(copy);
        int total = 0;
        int j = 0;
        int i = 0;
        // 1 5 2 7
        // 1 2 5 7
        while (i < identification.size() && j < identification.size()) {
            if (identification.get(i) == copy.get(j)) {
                i++;
                j++;
            } else {
                i++;
                total ++;
            }
        }
        return total;
    }
}