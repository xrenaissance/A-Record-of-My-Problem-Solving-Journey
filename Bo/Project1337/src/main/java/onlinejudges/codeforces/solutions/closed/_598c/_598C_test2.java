package main.java.onlinejudges.codeforces.solutions.closed._598c;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class _598C_test2 {

    /*

0.0050250858559360845
0.0050250858559361955

     */
    public static void p(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        test1();
    }

    static void angles() {
        int ax = -9901;
        int ay = 9900;

        int bx = -10000;
        int by = 9899;
        calculate(ax, ay, bx, by);


        ax = 9800;
        ay = 9901;

        bx = 9899;
        by = 9900;
        calculate(ax, ay, bx, by);

        ax = 1;
        ay = 1;

        bx = 1;
        by = 1;
        calculate(ax, ay, bx, by);
    }
    static void calculate(int ax, int ay, int bx, int by) {
//        double angle1 = Math.atan2(ay, ax);
//        double angle2 = Math.atan2(by, bx);
        double angle1 = Math.atan2(ay, ax);
        double angle2 = Math.atan2(by, bx);

        double diffAngle = angle1 - angle2;

        p("angel1 = " + angle1);
        p("angel2 = " + angle2);
        p("diffAngle = " + diffAngle);
    }

    public static void test1(){
        BigDecimal b = new BigDecimal("35.3456").setScale(2, RoundingMode.HALF_UP);
// result = 35.3456
        System.out.println(b);
    }
}
