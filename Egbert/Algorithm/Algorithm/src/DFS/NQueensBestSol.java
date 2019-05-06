package DFS;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Egbert Li
 * @date 5/5/2019
 * Time: O()
 * Space:
 */
public class NQueensBestSol {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiagonals = new boolean[2 * n - 1];
        boolean[] usedRevDiagonals = new boolean[2 * n - 1];
        List<Integer> curr = new ArrayList<>();
        nQueens(n, 0, curr, result, usedColumns, usedDiagonals, usedRevDiagonals);
        return result;
    }
    private void nQueens(int n, int row, List<Integer> curr, List<List<Integer>> result,
                         boolean[] usedColumns, boolean[] usedDiagonals,
                         boolean[] usedRevDiagonals) {
        if (row == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
                curr.add(i);
                mark(n ,row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                nQueens(n, row + 1, curr, result, usedColumns, usedDiagonals, usedRevDiagonals);
                curr.remove(curr.size() - 1);
                unMark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }
    private boolean valid(int n,int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                          boolean[] usedRevDiagonals) {
        return !usedColumns[col] && !usedDiagonals[row + col] &&
                !usedRevDiagonals[col - row + n - 1];
    }
    private void mark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                      boolean[] usedRevDiagonals) {
        usedColumns[col] = true;
        usedDiagonals[row + col] = true;
        usedRevDiagonals[col - row + n - 1] = true;
    }
    private void unMark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                        boolean[] usedRevDiagonals) {
        usedColumns[col] = false;
        usedDiagonals[row + col] = false;
        usedRevDiagonals[col - row + n - 1] = false;
    }

}
