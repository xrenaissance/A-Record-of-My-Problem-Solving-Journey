package DropBoxTag;

/**
 * @leetcode https://leetcode.com/problems/implement-strstr/
 * @Time m + n
 * @Space 1
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        int sourceLength = haystack.length();
        int targetLength = needle.length();
        for (int i = 0; i < sourceLength - targetLength + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
