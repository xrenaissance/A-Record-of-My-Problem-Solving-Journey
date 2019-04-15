package StringI;

/**
 * @author Egbert Li
 * @date 16/04/2017
 * Time: O(2 * n)
 * Space(1)
 */
public class DecompressStringIIBestSol {
    public String decompress(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        int count = 0;
        char[] array = input.toCharArray();
        return decodeLong(array, decodeShort(array));
    }
    // return the length of the decoded string
    // only cares about "a0", "a1", "a2"
    // the decoded st ring is shorter
    private int decodeShort(char[] array) {
        int end = 0;
        for (int i = 0; i < array.length; i += 2) {
            int digit = getDigit(array[i + 1]);
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    array[end++] = array[i];
                }
            } else {
                array[end++] = array[i];
                array[end++] = array[i + 1];
            }
        }
        return end;
    }
    //
    private String decodeLong(char[] array, int length) {
        // we need to calculate the new required length
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = getDigit(array[i]);
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        char[] result = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            int digit = getDigit(array[i]);
            if (digit > 2 && digit <= 9) {
                i--;
                for (int j = 0; j < digit; j++) {
                    result[end--] = array[i];
                }
            } else {
                result[end--] = array[i];
            }
        }
        return new String(result);
    }

    private int getDigit(char digit) {
        return digit - '0';
    }
}
