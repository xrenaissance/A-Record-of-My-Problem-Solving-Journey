package Facebook;

/**
 * @leetcode https://leetcode.com/problems/verifying-an-alien-dictionary/
 * @Time n = number of nodes
 * @Space M = average length of neighbors
 */
public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mapping = new int[26];
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compareString(words[i - 1], words[i], mapping) > 0) {
                return false;
            }
        }

        return true;
    }

    private int compareString(String word1,
                              String word2,
                              int[] mapping) {
        int compare = 0;
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            int index1 = word1.charAt(i) - 'a';
            int index2 = word2.charAt(i) - 'a';
            compare = mapping[index1] - mapping[index2];
            if (compare != 0) {
                break;
            }
        }

        return compare == 0 ? word1.length() - word2.length() : compare;
    }
}
