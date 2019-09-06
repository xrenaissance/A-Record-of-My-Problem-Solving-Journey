package StringI;

public class ReverseWordsInASentenceII {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = removeSpace(array);
        reverse(array, 0, end);
        return new String(array, 0, end);
    }
    private int removeSpace(char[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            } else {
                array[slow++] = array[fast];
            }
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            return slow - 1;
        }
        return slow;
    }
    private void reverse(char[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
