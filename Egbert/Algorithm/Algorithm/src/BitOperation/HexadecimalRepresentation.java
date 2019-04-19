package BitOperation;

/**
 * @author Egbert Li
 * @date 19/04/2019
 * Time: O(2 N)
 * Space: O(1)
 */
public class HexadecimalRepresentation {
    public String hex(int number) {
        // handle the corn case first
        if (number == 0) {
            return "0x0";
        }
        // using StringBuilder to store the result
        // since every time the the new character will be
        // append at the end of StringBuilder, which is O(1)
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % 16;
            if (remainder < 10) {
                result.append((char)('0' + remainder));
            } else {
                result.append((char)('A' + remainder - 10));
            }
            number >>>= 4;
        }
        result.append('x');
        result.append('0');
        // reverse Result, O(n)
        result.reverse();
        return result.toString();
    }
}
