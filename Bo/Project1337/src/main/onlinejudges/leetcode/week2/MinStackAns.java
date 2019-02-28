package main.onlinejudges.leetcode.week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackAns {

    private Deque<Integer> d;
    private Deque<Integer> dmin;


    /**
     * initialize your data structure here.
     */
    public MinStackAns() {
        d = new ArrayDeque<>();
        dmin = new ArrayDeque<>();
    }

    public void push(int x) {
        d.addFirst(x);
        if (dmin.isEmpty() || dmin.getFirst() > x) {
            dmin.addFirst(x);
        } else {
            dmin.addFirst(dmin.getFirst());
        }
    }

    public void pop() {
        d.removeFirst();
        dmin.removeFirst();
    }

    public int top() {
        return d.getFirst();
    }

    public int getMin() {
        return dmin.getFirst();
    }

    public void hack() {
        System.out.println("----- hacking start - main stack -----");

        Deque<Integer> tempD = new ArrayDeque<>();
        while(!this.d.isEmpty()) {
            int cur = this.d.getFirst();
            this.d.pop();
            System.out.println("popping out " + cur);
            tempD.addFirst(cur);
        }

        while(!tempD.isEmpty()) {
            int cur = tempD.getFirst();
            tempD.pop();
            this.d.addFirst(cur);
        }

        System.out.println("----- hacking start - dmin stack -----");
        Deque<Integer> tempDmin = new ArrayDeque<>();
        while(!this.dmin.isEmpty()) {
            int cur = this.dmin.getFirst();
            this.dmin.pop();
            System.out.println("popping out " + cur);
            tempDmin.addFirst(cur);
        }

        while(!tempDmin.isEmpty()) {
            int cur = tempDmin.getFirst();
            tempDmin.pop();
            this.dmin.addFirst(cur);
        }
        System.out.println("----- hacking end -----");
    }

    public static void main(String args[]) {
        MinStackAns m = new MinStackAns();
        System.out.println("========================");
        m.hack();
        System.out.println("========================");
        m.push(-2);
        m.hack();
        System.out.println("========================");
        m.push(0);
        m.hack();
        System.out.println("========================");
        m.push(-3);
        m.hack();
        System.out.println("========================");
        m.pop();
        m.hack();
        System.out.println("========================");
        m.pop();
        m.hack();
        System.out.println("========================");
        m.pop();
        m.hack();


//        System.out.println(m.getMin());
//        m.pop();
//
//
//        m.hack();
//
//        System.out.println(m.top());
//        System.out.println(m.getMin());
    }
}

