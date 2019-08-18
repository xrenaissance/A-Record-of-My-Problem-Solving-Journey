package GoogleTaged;

/**
 * @leetcode https://leetcode.com/problems/to-lower-case/
 * @Time N
 * @Space N
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        //return str.toLowerCase();
            if (str == null || str.length() == 0) {
                return str;
            }
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if ('A' <= array[i] && array[i] <= 'Z') {
                    array[i] = (char)(array[i] - 'A' + 'a');
                }
            }
            return new String(array);
    }
}
