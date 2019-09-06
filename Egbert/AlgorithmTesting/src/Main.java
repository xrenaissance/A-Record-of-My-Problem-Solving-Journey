import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        //int value = SmallestDenominator.findSmallest((float) 0.4, 52);
        //System.out.println(value);
//        int[] test = new int[]{0, 1, 6, 9, 5, 3, 2, -4, -5};
//        int result = SearchInBitonicArray.findMax(test);
//        System.out.println(result);
//        String input1 = "abadaecccccc";
//        String input2 = "ababcc";
//        String input3 = "abbabcddccce";
//        System.out.println(LongestSubstringWithKtypesCharacters.longest(input1, 2));
//        System.out.println(LongestSubstringWithKtypesCharacters.longest(input2, 3));
//        System.out.println(LongestSubstringWithKtypesCharacters.longest(input3, 2));

        int[] array = new int[]{1, 5, 2, 7};
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            input.add(array[i]);
        }
        System.out.println("min moves: " + GetMinimumMoves.getMinimumMoves(input));
        int[][] maze = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };
        int[][] maze2 = new int[][] {
                {1, 1},
                {0, 1}
        };
        System.out.println("maze: " + NumberOfPaths.numberOfPaths(maze));
        System.out.println("maze1: " + NumberOfPaths.numberOfPaths(maze2));
        String a = "abc";
        String b = "def";
        String c = new StringBuilder().append(a).append(b).toString();
        System.out.println(c + ": " + c.length());

        System.out.println("---------------------------------------");
        int index = (int) (Math.random() * 51);
        System.out.println(index);

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        // char[] inputChar = new char[]{'a', 'b', 'c'};
        // PermutationTest.permutation(inputChar, 0);
        System.out.println('9' - '0');
        System.out.println('c' - 'a');
        System.out.println('A' - 'a');
    }
    public static void printArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i] + " -> ");
        }
    }
//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//        ListNode six = new ListNode(6);
//
//        // construct List one 1 -> 4 -> 6 -> null
//        one.next = four;
//        four.next = six;
//
//        // construct List two 2 -> 3 -> 5 -> null
//        two.next = three;
//        three.next = five;
//
//        System.out.println("Before: ");
//        printLinkedList(one);
//        System.out.println();
//        printLinkedList(two);
//        System.out.println();
//
//        // Apply method
//        ListNode mergerHead = MergeTwoSortedLinkedList.merge(one, two);
//        System.out.println("Mergered List: ");
//        printLinkedList(mergerHead);
//        System.out.println();
//        System.out.println("After: ");
//        printLinkedList(one);
//        System.out.println();
//        printLinkedList(two);
//        System.out.println();
//        int a = 8, b = -9;
//        System.out.println((a ^ b) >> 31);
//    }
//    public static void printLinkedList(ListNode head) {
//        if (head == null) {
//            System.out.print("null");
//            return;
//        }
//        System.out.print(head.value + " -> ");
//        printLinkedList(head.next);
//    }
}
