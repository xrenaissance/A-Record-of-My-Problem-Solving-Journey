package main.java.onlinejudges.leetcode.week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheCelebritySimple {
    private boolean knows(int a, int b){
        return false;
    }
    public int findCelebrity(int n) {

        if(n == 0 || n == 1) {
            return -1;
        }

        Deque<Integer> candidates = new ArrayDeque<Integer>();

        for(int i = 1; i < n; i++) {
            candidates.addLast(i);
        }

        while(candidates.size() >=2 ) {
            int a = candidates.removeFirst();
            int b = candidates.removeFirst();

            if(knows(a, b)) {
                candidates.addLast(b);
            } else {
                candidates.addLast(a);
            }
        }

        int candidate = candidates.removeFirst();

        for(int i = 1; i < n; i++) {
            if(i == candidate)
                continue;

            if(!knows(i, candidate) || knows(candidate, i))
                return -1;
        }

        return candidate;
    }

}
