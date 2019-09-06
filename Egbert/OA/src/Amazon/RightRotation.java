package Amazon;

public class RightRotation {
    public static int rightRotate(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 ||
            word2.length() == 0 || word1.length() != word2.length()) {
            return -1;
        }
        //String str = word1 + word2;
        //return str.indexOf(word2) != -1 ? 1 : -1;
        int left = 0;
        int right = word2.length() - 1;
        return rightRotateRecursive(word1, word2, left, right);
    }
    private static int rightRotateRecursive(String word1, String word2,
                                   int left, int right) {
        if (left >= word1.length()) {
            return 1;
        }
        if (word1.charAt(left) == word2.charAt(right)) {
           return  rightRotateRecursive(word1, word2, left + 1, right - 1);
        } else {
            return -1;
        }
    }
}
