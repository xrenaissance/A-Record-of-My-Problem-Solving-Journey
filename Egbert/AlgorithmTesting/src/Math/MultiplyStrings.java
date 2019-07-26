package Math;

/**
 * @leetcode https://leetcode.com/problems/multiply-strings/
 * @date 26/7/2019 @Time m * n + m + n @Space m + n
 * Explanation: Start from right to left, perform multiplication on every
 * pair of digits, and add them together. Let's draw the process!
 * From the following draft, we can immediately
 * conclude:
 * `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[pos2];
                pos[pos1] += sum / 10;
                pos[pos2] = sum % 10;
            }
        }
        StringBuilder sol = new StringBuilder();
        for (int num : pos) {
            if (!(sol.length() == 0 && num == 0)) {
                sol.append(num);
            }
        }
        return sol.length() == 0 ? "0" : sol.toString();
    }
}
