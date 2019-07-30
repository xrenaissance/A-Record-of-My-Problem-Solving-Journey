package String;

/**
 * @leetcode https://leetcode.com/problems/isomorphic-strings/
 * @Time n
 * @Space 256 * 2
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] projS = new int[256];
        int[] projT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int indexS = s.charAt(i);
            int indexT = t.charAt(i);
            if (projS[indexS] != projT[indexT]) {
                return false;
            }
            projS[indexS] = i + 1;
            projT[indexT] = i + 1;
        }
        return true;
    }
}
