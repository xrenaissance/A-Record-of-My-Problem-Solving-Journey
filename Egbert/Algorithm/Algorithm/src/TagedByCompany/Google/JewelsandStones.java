package TagedByCompany.Google;

/**
 * @leetcode https://leetcode.com/problems/jewels-and-stones/
 * @Time m + n
 * @Space O 58
 */
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int total = 0;
        int[] charFreq = new int[58];
        for (int i = 0; i < J.length(); i++) {
            charFreq[J.charAt(i) - 'A']++;
        }
        for (int i = 0; i < S.length(); i++) {
            if (charFreq[S.charAt(i) - 'A'] > 0) {
                total++;
            }
        }
        return total;
    }
}
