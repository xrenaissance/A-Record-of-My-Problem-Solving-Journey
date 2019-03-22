public class Main {

    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 6, 9, 5, 3, 2, -4, -5};
        int result = SearchInBitonicArray.findMax(test);
        System.out.println(result);
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
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
