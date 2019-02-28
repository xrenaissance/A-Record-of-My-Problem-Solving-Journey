package main.java.onlinejudges.leetcode.week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheCelebrityNoExtraSpace {

    private boolean knows(int a, int b){
        return false;
    }

    private int solution(int n) {

        int candidate = 0;

        for(int i = 1; i < n; i++) {
            if(knows(candidate, i))
                candidate = i;

        }

        for(int i = 0; i < n; i++) {
            if(i == candidate)
                continue;

            if(knows(candidate, i) || !knows(i, candidate))
            return -1;
        }

        return candidate;
    }



}