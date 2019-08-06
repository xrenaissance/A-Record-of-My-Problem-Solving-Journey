package Hash;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/valid-sudoku/
 * @Time 3 * 9 * 9
 * @Space 9
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return true;
        }
        boolean[] visited = new boolean[9];

        // for rows
        for (int row = 0; row < 9; row++) {
            Arrays.fill(visited, false);
            for (int col = 0; col < 9; col++) {
                if (!process(visited, board[row][col])) {
                    return false;
                }
            }
        }

        // for cols
        for (int col = 0; col < 9; col++) {
            Arrays.fill(visited, false);
            for (int row = 0; row < 9; row++) {
                if (!process(visited, board[row][col])) {
                    return false;
                }
            }
        }
        // for squares
        for (int row = 0; row < 9; row += 3) {
            Arrays.fill(visited, false);
            for (int col = 0; col < 9; col += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    char ch = board[row + k / 3][col + k % 3];
                    if (!process(visited, ch)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean process(boolean[] visited, char digit) {
        if (digit == '.') {
            return true;
        }
        int num = digit - '0';
        if (num < 0 || num > 9 || visited[num - 1]) {
            return false;
        }
        visited[num - 1] = true;
        return true;
    }
}
