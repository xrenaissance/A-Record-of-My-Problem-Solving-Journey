public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array.length == 0 || k == 0) {
      return new int[0]; 
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1.equals(o2)) return 0;
        return o1 > o2 ? -1 : 1;
      }
    });
    for (int i = 0; i < k; i++) {
      maxHeap.offer(array[i]); 
    }
    for (int i = k; i < array.length; i++) {
      if(maxHeap.peek() > array[i]) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    int[] result = new int[k];
    int j = k - 1;
    while (!maxHeap.isEmpty()) {
      result[j] = maxHeap.poll();
      j--;
    }
    return result;
  }
}
