package main.onlinejudges.codeforces.solutions.closed._598c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _598C_test1 {

    /*
8
1 100
100 1
100 -1
1 -100
-1 -100
-100 -1
-100 1
-1 100

4
-9901 9900
-10000 9899
9899 9801
9899 9900

     */

    public static void p(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        sc.nextLine();

        ArrayList<MyVector> myVectors = new ArrayList<MyVector>();

        for (int i = 0; i < total; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();

            myVectors.add(new MyVector(i + 1, x, y));
        }

        Collections.sort(myVectors, new Comparator<MyVector>() {
                    public int compare(MyVector s1, MyVector s2) {
                        return Double.compare(s1.atan2, s2.atan2);
                    }
                }
        );

        // Print Info
        for (int i = 0; i < total; i++) {
            p("vector: " + "|" + myVectors.get(i).id + "|" + myVectors.get(i).x + "|" + myVectors.get(i).y + "|" + myVectors.get(i).atan2);
        }

        // Compare
        Double minDiffAtan = Double.parseDouble("7");
        int x = 0;
        int y = 0;
        for (int i = 1; i < total; i++) {
            Double diffAtan = myVectors.get(i).atan2 - myVectors.get(i - 1).atan2;
            if (diffAtan < minDiffAtan) {
                minDiffAtan = diffAtan;
                x = myVectors.get(i).id;
                y = myVectors.get(i - 1).id;
            }
            p("comparison: i = " + i + "; x/y = " + myVectors.get(i).id + "/" + myVectors.get(i-1).id + "; diffAtan = " + diffAtan + "; minDiffAtan = " + minDiffAtan);
        }

        // Special case
        MyVector first = myVectors.get(0);
        MyVector last = myVectors.get(myVectors.size() - 1);
        if (first.atan2 < 0 && last.atan2 > 0) {
            Double lastDiffAtan = (Math.PI + first.atan2) + (Math.PI - last.atan2);
            if (lastDiffAtan < minDiffAtan) {
                minDiffAtan = lastDiffAtan;
                x = first.id;
                y = last.id;
            }
        }
        p(x + " " + y);
    }

    static class MyVector {
        public int id;
        public int x;
        public int y;
        public Double atan2;

        MyVector(int i, int a, int b) {
            id = i;
            x = a;
            y = b;
            atan2 = Math.atan2(x, y);
        }


    }
}
