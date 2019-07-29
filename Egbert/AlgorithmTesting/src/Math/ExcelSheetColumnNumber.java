package Math;

/**
 * @leetcode https://leetcode.com/problems/excel-sheet-column-number/1
 * @date 29/7/2019
 * @Time N
 * @Spce 1
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        if (s == null || s.length() == 0){
            return sum;
        }
        for (int i = 0; i < s.length(); i++) {
            int currNum = (int)(s.charAt(i) - 'A')  + 1;
            sum = sum * 26 + (currNum);
        }
        return sum;
    }
}
