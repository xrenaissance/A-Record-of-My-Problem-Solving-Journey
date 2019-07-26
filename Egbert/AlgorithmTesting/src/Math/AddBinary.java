package Math;

/**
 * @leetcode https://leetcode.com/problems/add-binary/
 * @date 27/7/2019
 * @Time n + n
 * @Space n  if stringbuilder is counted
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int aEndIndex = a.length() - 1;
        int bEndIndex = b.length() - 1;

        StringBuilder sol = new StringBuilder();
        int carry = 0;
        while (aEndIndex >= 0 || bEndIndex >= 0) {
            int sum = carry;
            if (aEndIndex >= 0) {
                sum += (a.charAt(aEndIndex--) - '0');
            }
            if (bEndIndex >= 0) {
                sum += (b.charAt(bEndIndex--) - '0');
            }
            sol.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sol.append(carry);
        }
        return sol.reverse().toString();
    }
}
