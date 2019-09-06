package Amazon;

/**
 * @author Egbert Li
 * @Date 9/5/2019
 * @link https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Time: O N
 * Space: O N
 */
public class ReverseVowelsOfaString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (isVowel(array[left]) && isVowel(array[right])) {
                swap(array, left++, right--);
            } else if (isVowel(array[left])) {
                right --;
            } else {
                left++;
            }
        }
        return new String(array);
    }
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' ||ch == 'u';
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
