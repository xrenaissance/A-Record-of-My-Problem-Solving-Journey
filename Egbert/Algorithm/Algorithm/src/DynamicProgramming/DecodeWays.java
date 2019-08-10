package DynamicProgramming;

/**
 * @leetcode https://leetcode.com/problems/decode-ways/
 * @Time N
 * @Space N, can reduce to 2
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // ways[i] means ith index, the number of decode ways
        // ways[i] = ways[i] + ways[i - 1] if only decode in one digit
        // ways[i] += ways[i - 2] if i >= 2 and num(s[i-2][i - 1] >= 10 and <= 26)
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                ways[i] += ways[i - 1];
            }
            int num = 10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0');
            if (num >= 10 && num <= 26) {
                ways[i] += ways[i - 2];
            }
        }
        return ways[s.length()];
    }
}
