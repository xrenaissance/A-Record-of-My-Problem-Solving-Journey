package Math;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/plus-one/
 * @date 26/7/2019
 * @Time N
 * @Space N if need
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[digits.length + 1];
        newNum[0] = 1;
        return newNum;
    }
    public static void main(String[] args) {
        int[] input1 = new int[] {4,9,9};
        PlusOne p = new PlusOne();
        int[] result = p.plusOne(input1);
        Arrays.stream(result).forEach(num -> System.out.print(num + " "));
    }
}
