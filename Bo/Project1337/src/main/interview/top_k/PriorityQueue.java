package main.interview.top_k;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {
        int a[] = {-666, 51, -1996, 1100, 2, 2288, 0, 88, 779};
        int r[] = solution(a, 5);
        for(int i : r)
            System.out.print(i + " ");
    }

    private static int[] solution(int[] a, int k) {
        Queue<Integer> q = new java.util.PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i : a)
            q.add(i);
        int r[] = new int[k];
        for(int i = 0; i < k; i ++)
            r[i] = q.poll();
        return r;
    }
}
