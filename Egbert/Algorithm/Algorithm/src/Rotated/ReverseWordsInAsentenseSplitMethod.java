package Rotated;

/**
 * @author Egbert Li
 * @date 5/4/2019
 * Time complexity: O(n)
 * Space complexity O(n)
 */
public class ReverseWordsInAsentenseSplitMethod {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        StringBuilder strBuilder = new StringBuilder();
        String[] strArray = input.split(" ");
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (!strArray[i].equals("")) {
                if (strArray[i].length() > 0) {
                    strBuilder.append(strArray[i]);
                    strBuilder.append(" ");
                }
            }
        }
        return strBuilder.toString().trim();
    }
}
