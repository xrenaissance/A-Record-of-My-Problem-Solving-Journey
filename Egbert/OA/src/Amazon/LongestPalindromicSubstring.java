package Amazon;

public class LongestPalindromicSubstring {
    private static LongestPalindromicSubstring ourInstance = new LongestPalindromicSubstring();

    public static LongestPalindromicSubstring getInstance() {
        return ourInstance;
    }

    private LongestPalindromicSubstring() {
    }
}
