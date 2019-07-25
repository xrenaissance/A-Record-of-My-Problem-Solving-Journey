package String;

/**
 * @leetcode https://leetcode.com/problems/longest-common-prefix/
 * @date 24/7/2019
 * @Time m = average length of strings n = size of array m * n
 * @Space m * n
 */
public class LongestCommonPrefix {
    // Solution 1: using indexOf
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        System.out.println(prefix);
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    // Solution 2: My inital solution
    public String longestCommonPrefixIterative(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int endIndex = 0;
        while(true) {
            for (int j = 0 + 1; j < strs.length; j++) {
                if (endIndex < strs[0].length() && endIndex < strs[j].length() &&
                        strs[0].charAt(endIndex) == strs[j].charAt(endIndex)) {
                    continue;
                } else {
                    return strs[0].substring(0, endIndex);
                }
            }
            endIndex++;
        }
    }
    public static void main(String[] args) {
        String[] input1 = new String[] {"abc"};
        String[] input2 = new String[] {"gdbchcihiahf", "gdb", "gd", "gdbc23ff"};
        String[] input3 = new String[]{"flower","flow","flight"};
        String[] input4 = new String[]{"dog","racecar","car"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(input1));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(input2));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(input3));
        System.out.println(LongestCommonPrefix.longestCommonPrefix(input4));
        System.out.println("gdb".indexOf("gdbchcihiahf"));
    }
}
