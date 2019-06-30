package TwoPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6265122324480000
 * @author Egbert Li
 * @date 30/06/2019
 * @Time O N
 * @Space O 1
 */
public class BackspaceCompareBestSolution {
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int idx1 = getNextValidCharIndex(str1, index1);
            int idx2 = getNextValidCharIndex(str2, index2);
            if (idx1 < 0 && idx2 < 0) {
                return true;
            } else if (idx1 < 0 || idx2 < 0) {
                return false;
            } else if (str1.charAt(idx1) != str2.charAt(idx2)) {
                return false;
            } else {
                index1 = idx1 - 1;
                index2 = idx2 - 1;
            }
        }
        return true;
    }
    private static int getNextValidCharIndex(String str, int index) {
        int spaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                spaceCount++;
            } else if (spaceCount > 0) {
                spaceCount--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println(BackspaceCompareBestSolution.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompareBestSolution.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompareBestSolution.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompareBestSolution.compare("xywrrmp", "xywrrmu#p"));
    }
}
