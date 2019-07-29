package Math;

/**
 * @leetcode https://leetcode.com/problems/excel-sheet-column-title/
 * @date 29/7/2019
 * @Time log N
 * @Space 1
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            char letter = (char)('A' + n % 26);
            result.insert(0, letter);
            n /= 26;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(701 % 26);
        System.out.println(701 / 26);
    }
}
