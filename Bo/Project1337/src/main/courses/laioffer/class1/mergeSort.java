package main.courses.laioffer.class1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class mergeSort {
    public static void main(String[] args) {
        int a[] = {1, -1231, 15, 6, 88, 991, 5, -666, 712, 67, 588};
        int n = a.length;
        int result[] = mergeSort(a, 0, n - 1);
        for(int r : result) {
            System.out.print(r + " ");;
        }
    }

    // TODO WIP
    public static int[] mergeSort(int[] a, int start, int end) {
        // If size is small enough to return
        if(end == start) {
            int[] result = {a[start]};
            return result;
        }

        // If further recursion is needed
        else {
            int half = start + (end - start) / 2;
            int firstHalf[] = mergeSort(a, start, half);
            int secondHalf[] = mergeSort(a, half + 1, end);
            int merged[] = new int[end - start + 1];

            int firstPos = 0;
            int secondPos = 0;
            int mergedPos = 0;

            while(mergedPos != end - start) {
                if(firstPos == firstHalf.length - 1) {
                    merged[mergedPos] = secondHalf[secondPos];
                    secondPos ++;
                }
                else if(secondPos == secondHalf.length - 1) {
                    merged[mergedPos] = firstHalf[firstPos];
                    firstPos ++;
                }
                else if(firstHalf[firstPos] >= secondHalf[secondPos]) {
                    merged[mergedPos] = firstHalf[firstPos];
                    firstPos ++;
                } else {
                    merged[mergedPos] = secondHalf[secondPos];
                    secondPos ++;
                }
                mergedPos ++;
            }
            return merged;
        }


    }
}
