public class NumberOfPaths {
    public static int numberOfPaths(int[][] maze) {
        if (maze == null || maze.length == 0) {
           return 0;
        } else if (maze[0][0] == 0) {
            return 0;
        }
        int rows = maze.length;
        int cols = maze[0].length;
        // left most
        for (int i = 0; i < rows; i++) {
           if (maze[i][0] != 1) {
               // if maze[i][0] == 0, we cannot pass though
              // if visited, no need to visit again
               break;
           }
        }
        // same as left most, top most
        for (int i = 1; i < cols; i++) {
            if (maze[0][i] != 1) {
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // if cannot pass, we don't care
                if (maze[i][j] == 0) {
                    continue;
                }
                if (maze[i - 1][j] > 0) {
                    maze[i][j] =  maze[i - 1][j];
                }
                if (maze[i][j - 1] > 0) {
                    maze[i][j] +=  maze[i][j - 1];
                }
            }
        }
        if (maze[rows - 1][cols - 1] > 0) {
            return maze[rows - 1][cols - 1];
        }
        return 0;
    }
}
