package DFS;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Egbert Li
 * @date 5/5/2019
 * Time:
 */
public class NQueens {
    // assumption: n  > 0
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        // index = row, value = column number(Position)
        List<Integer> curr = new ArrayList<>();
        findPositions(n, curr, result);
        return result;
    }
    //
    private void findPositions(int n, List<Integer> curr,
                               List<List<Integer>> result) {
        // base case: when all the rows we know where the queen is positioned
        if (curr.size() == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (validPosition(curr, i)) {
                curr.add(i);
                findPositions(n, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    // validate the current position, O(n)
    private boolean validPosition(List<Integer> curr, int column) {
        int row = curr.size();
        for (int i = 0; i < curr.size(); i++) {
            if (curr.get(i) == column || Math.abs(curr.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }}
