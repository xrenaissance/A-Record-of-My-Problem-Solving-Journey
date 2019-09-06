package DP;

/**
 * @author Egbert Li
 * @date
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        if (one == null && two == null) {
            return 0;
        }
        int[][] distance = new int[one.length() + 1][two.length()  +1];
        distance[0][0] = 0;
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) { // if one is ""
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i; // if two is ""
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) { // do nothing
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(distance[i - 1][j - 1], distance[i][j - 1]); // replace and insert
                    distance[i][j] = Math.min(distance[i][j], distance[i - 1][j]) + 1; // delete
                }
            }
        }
        return distance[one.length()][two.length()];
    }
}
