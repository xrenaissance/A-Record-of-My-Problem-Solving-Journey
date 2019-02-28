package main.onlinejudges.leetcode.week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackMy {

    Deque<Integer> stack;
    Deque<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStackMy() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addFirst(x);
        if(min.isEmpty() || min.getFirst() > x) {
            min.addFirst(x);
        } else {
            min.addFirst(min.getFirst());
        }
    }

    public void pop() {
        stack.removeFirst();
        min.removeFirst();
    }

    public int top() {
        stack.getFirst();
        return stack.getFirst();
    }

    public int getMin() {
        return min.getFirst();
    }


    public void hack() {
        System.out.println("----- hacking start - main stack -----");

        Deque<Integer> tempD = new ArrayDeque<>();
        while (!this.stack.isEmpty()) {
            int cur = this.stack.getFirst();
            this.stack.pop();
            System.out.println("popping out " + cur);
            tempD.addFirst(cur);
        }

        while (!tempD.isEmpty()) {
            int cur = tempD.getFirst();
            tempD.pop();
            this.stack.addFirst(cur);
        }

        System.out.println("----- hacking start - dmin stack -----");
        Deque<Integer> tempDmin = new ArrayDeque<>();
        while (!this.min.isEmpty()) {
            int cur = this.min.getFirst();
            this.min.pop();
            System.out.println("popping out " + cur);
            tempDmin.addFirst(cur);
        }

        while (!tempDmin.isEmpty()) {
            int cur = tempDmin.getFirst();
            tempDmin.pop();
            this.min.addFirst(cur);
        }
        System.out.println("----- hacking end -----");
    }

    public static void main(String args[]) {
        MinStackMy m = new MinStackMy();
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

    }
}

