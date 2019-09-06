package Subsets;

public class Heart {
//    public static void main(String[] args) {
//        StdDraw.setXscale(-1.5, +1.5);
//        StdDraw.setYscale(-1.5, +1.5);
//        StdDraw.setPenColor(StdDraw.PINK);
//
//        // draw diamond
//        double[] xs = { -1,  0, 1, 0 };
//        double[] ys = {  0, -1, 0, 1 };
//        StdDraw.filledPolygon(xs, ys);
//
//        // circles
//        StdDraw.filledCircle(+0.5, 0.5, 1 / Math.sqrt(2));
//        StdDraw.filledCircle(-0.5, 0.5, 1 / Math.sqrt(2));
//    }
public static void main(String[] args) {
    int n = 10;

    for (int i = -3*n/2; i <= n; i++) {
        for (int j = -3*n/2; j <= 3*n/2; j++) {

            // inside either diamond or two circles
            if ((Math.abs(i) + Math.abs(j) < n)
                    || ((-n/2-i) * (-n/2-i) + ( n/2-j) * ( n/2-j) <= n*n/2)
                    || ((-n/2-i) * (-n/2-i) + (-n/2-j) * (-n/2-j) <= n*n/2)) {
                System.out.print("* ");
            }
            else {
                System.out.print(". ");
            }
        }
        System.out.println();
    }
}
}
