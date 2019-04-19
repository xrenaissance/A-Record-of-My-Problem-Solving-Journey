package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * Time: O(N)
 * Space: O(1)
 */
public class AllUniqueCharactersIBitSol {
    public boolean allUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int record = 0;
        for (int i = 0; i < word.length(); i++) {
            int currPosition = word.charAt(i) - 'a';
            if (((record >> currPosition) & 1) == 1) {
                return false;
            } else {
                record |= (1 << currPosition);
            }
        }
        return true;
    }
}
