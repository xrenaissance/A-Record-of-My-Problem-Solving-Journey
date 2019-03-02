package main.courses.laioffer.class1;

public class mergeSort {
    public static void main(String[] args) {
        int a[] = {1, -1231, 15, 6, 88, 991, 5, -666, 712, 67, 588};
        int n = a.length;
        int result[] = mergeSort(a, 0, n - 1);
        for(int r : result) {
            System.out.print(r + " ");;
        }
    }

    public static int[] mergeSort(int[] a, int start, int end) {
        if(end == start)
            return new int[]{a[start]};
        else {
            int half = start + (end - start) / 2;
            int firstHalf[] = mergeSort(a, start, half);
            int secondHalf[] = mergeSort(a, half + 1, end);
            int merged[] = new int[end - start + 1];
            int firstPos = 0, secondPos = 0, mergedPos = 0;
            while(mergedPos != merged.length) {
                if(secondPos == secondHalf.length || (firstPos < firstHalf.length && firstHalf[firstPos] <= secondHalf[secondPos]))
                    merged[mergedPos] = firstHalf[firstPos ++];
                else
                    merged[mergedPos] = secondHalf[secondPos ++];
                mergedPos ++;
            }
            return merged;
        }
    }
}
