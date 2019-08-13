package BreadthAndBestFirstSearch;

import java.util.*;

/**
 * @lintcode https://www.lintcode.com/problem/sliding-puzzle-ii/description?_from=ladder&&fromId=14
 * @Time M * N
 * @Space M * N
 */
public class SlidingPuzzleII {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        String startState = matrixToString(init_state);
        String endState = matrixToString(final_state);
        if (startState.equals(endState)) {
            return 0;
        }
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new State(startState, 0));
        visited.add(startState);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State currState = queue.poll();
                for (State s : getNext(currState)) {
                    if (s.board.equals(endState)) {
                        return s.distance;
                    }
                    if (!visited.contains(s.board)) {
                        visited.add(s.board);
                        queue.offer(s);
                    }
                }
            }
        }
        return -1;
    }
    private List<State> getNext(State currState) {
        List<State> next = new ArrayList<>();
        int indexOfZero = currState.board.indexOf('0');
        int x = indexOfZero / 3;
        int y = indexOfZero % 3;
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < 3 && cy >= 0 && cy < 3) {
                char[] array = currState.board.toCharArray();
                array[indexOfZero] = array[cx * 3 + cy];
                array[cx * 3 + cy] = '0';
                next.add(new State(new String(array), currState.distance + 1));
            }
        }
        return next;
    }
    private String matrixToString(int[][] state) {
        StringBuilder result = new StringBuilder();
        int rows = state.length;
        int cols = state[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.append(state[i][j]);
            }
        }
        return result.toString();
    }
    public static class State {
        String board;
        int distance;
        public State(String board, int distance) {
            this.board = board;
            this.distance = distance;
        }
    }
}
