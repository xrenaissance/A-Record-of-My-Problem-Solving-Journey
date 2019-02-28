package main.java.onlinejudges.codeforces.solutions.closed._598c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _598C {

    // Model
    static Scanner sc = new Scanner(System.in);

    public static void p(Object s) {
        System.out.println(s);
    }

    public static void d(Object s) {
        System.out.println("[DEBUG] " + s);
    }

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {

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


        // Compare
        double minDiffAtane = 7;
        int x = 0;
        int y = 0;
        for (int i = 1; i < total; i++) {
            double diffAtan = myVectors.get(i).atan2 - myVectors.get(i - 1).atan2;
            if (diffAtan <= minDiffAtane) {
                minDiffAtane = diffAtan;
                x = myVectors.get(i).id;
                y = myVectors.get(i - 1).id;
            }
        }

        // Special case
        MyVector first = myVectors.get(0);
        MyVector last = myVectors.get(myVectors.size() - 1);
        if (first.atan2 < 0 && last.atan2 > 0) {
            double lastDiffAtan = (Math.PI + first.atan2) + (Math.PI - last.atan2);
            if (lastDiffAtan <= minDiffAtane) {
                minDiffAtane = lastDiffAtan;
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
        public double atan2;

        MyVector(int i, int a, int b) {
            id = i;
            x = a;
            y = b;
            atan2 = Math.atan2(x, y);
        }
    }
}



