package QueueAndStack;
import java.util.LinkedList;

/**
 * @author Egbert Li
 * @Date 28/03/2019
 *
 */
public class SortWith3StacksMergerSort {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        sort(s1, s2, s3, s1.size());
    }
    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2,
                      LinkedList<Integer> s3, int length) {
        if (length <= 1) {
            return;
        }
        int mid1 = length / 2;
        int mid2 = length - length / 2;
        for (int i = 0; i < mid1; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        // use the other stacks to sort s2/s1
        // after sorting the numbers in s2/s1 are in ascending order from top to
        // bottom in th two stacks
        sort(s2, s3, s1, mid1);
        sort(s1, s3, s2, mid2);
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2) {
            if (s2.peekFirst() < s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            } else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while (i < mid1) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while (j < mid2) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        // after mergering, the numbers are rin decending order from top to bottom
        // in s3, we need to push them to s1 so that they are in ascending order.
        for (int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
    }
}
