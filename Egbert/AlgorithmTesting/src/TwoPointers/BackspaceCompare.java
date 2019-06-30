package TwoPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6265122324480000
 * @author Egbert Li
 * @date 30/06/2019
 * @Time O N
 * @Space O M + N
 */
public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        String finalStr1 = removeSpace(str1);
        String finalStr2 = removeSpace(str2);
        return compareStr(finalStr1, finalStr2);
    }
    // Time: O N    Space: O N
    private static String removeSpace(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int strfinalEnd = 0;
        char[] charArray = str.toCharArray();
        for (int strEnd = 1; strEnd < charArray.length; strEnd++) {
            if (charArray[strEnd] != '#') {
                strfinalEnd++;
                charArray[strfinalEnd] = charArray[strEnd];
            } else {
                strfinalEnd--;
            }
        }
        return new String(charArray, 0, strfinalEnd + 1);
    }
    // O N
    private static boolean compareStr(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}
