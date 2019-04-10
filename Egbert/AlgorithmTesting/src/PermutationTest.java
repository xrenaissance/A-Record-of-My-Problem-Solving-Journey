public class PermutationTest {
    public static int count = 0;
    public static void permutation(char[] input, int index) {
        if (index == input.length) { // print solution and return
            System.out.println("print out solution: index = " + index);
            printArray(input);
           return;
        }
        // push each letter in the index-th position of the input str
        for (int i = index; i < input.length; i++) {
           System.out.println(count + "th before swap: i = " + i + " index = " + index);
           printArray(input);
           swap(input, index, i);
           System.out.println("after first swap: i = " + i + " index = " + index);
           printArray(input);
           System.out.println("---------------------------------");
           permutation(input, index + 1);
           swap(input, index, i);
           System.out.println(count + "th second swap: i = " + i + " index = " + index);
           printArray(input);
           System.out.println("++++++++++++++++++++++++++++++++++");
           count++;
        }
    }
    public static void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
    public static void printArray(char[] input) {
       for (int i = 0; i < input.length; i ++) {
            System.out.print(input[i] + " ");
       }
       System.out.println();
    }
}
