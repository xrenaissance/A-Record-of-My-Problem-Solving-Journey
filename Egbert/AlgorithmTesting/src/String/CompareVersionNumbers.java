package String;

/**
 * @leetcode https://leetcode.com/problems/compare-version-numbers/
 * @Time M + N
 * @Space M + N
 *
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        int num1 = 0;
        int num2 = 0;
        while (i < v1.length || j < v2.length) {
            num1 = 0;
            num2 = 0;
            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i++]);
            }
            if (j < v2.length) {
                num2 = Integer.parseInt(v2[j++]);
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
