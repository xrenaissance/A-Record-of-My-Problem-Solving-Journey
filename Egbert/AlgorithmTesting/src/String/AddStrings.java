package String;

/**
 * @leetcode https://leetcode.com/problems/add-strings/
 * same approach as https://leetcode.com/problems/add-binary/
 * @Time m + n
 * @Space max(m,n) + 1
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sol = new StringBuilder();
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += (num1.charAt(i--) - '0');
            }
            if (j >= 0) {
                sum += (num2.charAt(j--) - '0');
            }
            sol.append(sum % 10);
            sum /= 10;
        }
        if (sum > 0) {
            sol.append(sum % 10);
        }
        return sol.reverse().toString();
    }
}
