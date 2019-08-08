package Math;

/**
 * @leetcode https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    // sign + nums + . + nums + e + sign + nums
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim() + " ";
        char[] array = s.toCharArray();
        int length = array.length - 1;
        int i = 0;
        if (array[i] == '+' || array[i] == '-') {
            i++;
        }
        int numOfNums = 0;
        int numOfPoints = 0;
        while (Character.isDigit(array[i]) || array[i] == '.') {
            if (Character.isDigit(array[i])) {
                numOfNums++;
            }
            if (array[i] == '.') {
                numOfPoints++;
            }
            i++;
        }
        if (numOfNums <= 0 || numOfPoints > 1) {
            return false;
        }
        if (array[i] == 'e') {
            i++;
            if (array[i] == '+' || array[i] == '-') {
                i++;
            }
            if (i == length) {
                return false;
            }
            for (; i < length; i++) {
                if (!Character.isDigit(array[i])) {
                    return false;
                }
            }
        }
        return i == length;
    }
}
