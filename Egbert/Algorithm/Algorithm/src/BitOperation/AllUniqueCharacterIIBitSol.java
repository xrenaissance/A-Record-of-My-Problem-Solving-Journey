package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class AllUniqueCharacterIIBitSol {
    public boolean allUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int[] visited = new int[8];
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            int row = currLetter / 32;
            int col = currLetter % 32;
            if ((visited[row] >> col & 1) == 1) {
                return false;
            } else {
                visited[row] |= 1 << col;
            }
        }
        return true;
    }
}
