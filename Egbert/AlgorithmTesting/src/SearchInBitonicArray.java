public class SearchInBitonicArray {
    public static int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int maxIndex = findMax(array);
        if (target == array[maxIndex]) {
            return maxIndex;
        } else if (target > array[maxIndex]) {
            return -1;
        } else {
            int leftResult = ascendingBinarySearch(array, 0, maxIndex, target);
            if (leftResult != -1) {
                return leftResult;
            } else {
                return decendingBinarySearch(array, maxIndex, array.length - 1, target);
            }
        }
    }

    public static int ascendingBinarySearch (int[] array, int left,
                                       int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                System.out.println(array[mid]);
                return mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int decendingBinarySearch(int[] array, int left,
                                      int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                System.out.println(array[mid]);
                return mid;
            } else if (target > array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return - 1;
    }

    // Find the index of maximum number in the array
    public static int findMax(int[] array) {
        int left = 0, right = array.length - 1, target = array[0];
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return mid;
            } else if (array[mid] > array[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] > array[left]) {
            return right;
        }
        return left;
    }
}
