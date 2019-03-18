package BinarySearch;

/**
 * @author Egbert Li
 * @Date 18/03/2019
 * Time Complexity O(sqrt(x))
 */
public class SquareRootI {
    public int sqrt(int x) {
        int i = 1;
        while (i * i <= x) {
            if (i * i == x) {
                return i;
            }
            i++;
        }
        return i - 1;
    }
}
