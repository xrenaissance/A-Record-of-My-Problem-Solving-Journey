package Facebook;

/**
 * @leetcode https://leetcode.com/problems/string-compression/
 * @Time N
 * @Space 1
 */
public class StringCompression {
    // My initial solution
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        // [0, slow) processed data
        // [slow, fast) dumped data
        // [fast, rest] explore
        int slow = 0;
        int count = 1;
        for (int fast = 1; fast < chars.length; fast++) {
            if (chars[fast] == chars[fast - 1]) {
                count++;
            } else {
                chars[slow++] = chars[fast - 1];
                if (count > 1) {
                    slow = addInt(chars, slow, count);
                }

                count = 1;
            }
        }

        chars[slow++] = chars[chars.length - 1];
        if (count > 1) {
            slow = addInt(chars, slow, count);
        }

        return slow;
    }

    private int addInt(char[] chars, int slow, int count) {
        if (count / 1000 != 0) {
            chars[slow++] = (char)(count / 1000 + '0');
            count %= 1000;
        }

        if (count / 100 != 0) {
            chars[slow++] = (char)(count / 100 + '0');
            count %= 100;
        }

        if (count / 10 != 0) {
            chars[slow++] = (char)(count / 10 + '0');
            count %= 10;
        }

        chars[slow++] = (char)(count + '0');

        return slow;
    }
}
