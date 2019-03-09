public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array.length == 0 || k == 0) {
      return new int[0]; 
    }
    
    ArrayList<Integer> arrayCopy = new ArrayList<Integer>();
    for (int elem: array) {
      arrayCopy.add(elem);
    }
    PriorityQueue<Integer> miniHeap = new PriorityQueue<Integer>(k);
    for (int i = 0; i < array.length; i++) {
      miniHeap.offer(array[i]); 
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = miniHeap.poll();
    }
    return result;
  }
}
