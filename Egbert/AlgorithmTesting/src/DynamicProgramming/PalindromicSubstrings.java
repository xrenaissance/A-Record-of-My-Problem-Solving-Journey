package DynamicProgramming;

/**
 * @leetcode https://leetcode.com/problems/palindromic-substrings/
 * @Time DFS: n ^ 2
 * @space DFS: 1
 */
public class PalindromicSubstrings {


    // Solution 2: DFS
    public int countSubstringsDFS(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalin(s, i, j)) {
                    total++;
                }
            }
        }
        return total;
    }
    private boolean isPalin(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
