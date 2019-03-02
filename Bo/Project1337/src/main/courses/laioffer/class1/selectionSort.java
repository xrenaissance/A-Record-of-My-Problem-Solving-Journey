package main.courses.laioffer.class1;

public class selectionSort {
    public static void main(String[] args) {
        int a[] = {1, -1231, 15, 6, 88, 991};
        int n = 6;
        int result[] = solution(a, n);
        for(int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] solution (int[] a, int n) {
        // Outer loop: sort "unsorted part" of the array
        for(int i = 0; i < a.length - 1; i++) {
            int start = i;
            int maxPos = start;

            // get position of max element
            for(int j = start + 1; j < a.length; j++) {
                if(a[j] < a[maxPos]) {
                    maxPos = j;
                }
            }

            // swap
            int temp = a[start];
            a[start] = a[maxPos];
            a[maxPos] = temp;
        }

        return a;
    }
}
