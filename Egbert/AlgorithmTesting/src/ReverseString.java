public class ReverseString {
    public static String reverse(String input) {
        if (input == null || input.length() == 0)
            return input;
        char[] array = input.toCharArray();
        return reverse(array,0, array.length - 1);
    }
    private static String reverse(char[] array, int left, int right) {
       if (left >= right) {
           return new String(array);
       }
       swap(array, left, right);
       return reverse(array, left+ 1, right + 1);
    }
    private static void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
