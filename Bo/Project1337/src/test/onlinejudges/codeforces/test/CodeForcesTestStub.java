package java.onlinejudges.codeforces.test;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CodeForcesTestStub {

    public static void p(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> p = new PriorityQueue<Integer>();

        p.add(1);
        p.add(2);
        p.add(3);

        p(p);

        p(p.remove());
        p(p);

        p(p.remove());
        p(p);
    }
}
