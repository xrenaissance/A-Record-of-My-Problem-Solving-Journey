public class SmallestDenominator {
    public static int findSmallest(float num, int upper) {
        int up = 1;
        int down = 2;
        while (Math.abs(up/down - num) > 0.001 && down <= upper) {
            if (up/down > num) {
                down++;
            } else if (up/down < num) {
                up++;
            } else {
                return down;
            }
        }
        return up - 1;
    }
}
