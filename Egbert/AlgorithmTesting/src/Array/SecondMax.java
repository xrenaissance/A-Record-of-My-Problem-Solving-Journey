package Array;

/**
 * @Time N
 * @Space 1
 */
public class SecondMax {
    public static int secondMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = first;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (first > num && num > second) {
                second = num;
            }
        }
        return second == Integer.MIN_VALUE ? first : second;
    }
    public static void main(String[] main) {
        int[] input = new int[] {1, 2, 2, 3, 1, 1, 7, 5, 9, 4,4,2,1,12,12,5,29,30,9,9};
        int res = SecondMax.secondMax(input);
        System.out.println(res);
    }
}
