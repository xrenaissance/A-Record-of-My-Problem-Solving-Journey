package Facebook;

/**
 * @leetcode https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * @Time log N
 * @Space N
 */
public class ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal c = new ConvertaNumbertoHexadecimal();
        String res = c.toHex(26);
        System.out.println(res);
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder hex = new StringBuilder();
        int digit = 0;

        while (num != 0) {
            digit = num & 15;
            if (digit < 10) {
                hex.append(digit);
            } else {
                hex.append((char)(digit - 10 + 'a'));
            }

            num >>>= 4;
        }

        return hex.reverse().toString();
    }
}
