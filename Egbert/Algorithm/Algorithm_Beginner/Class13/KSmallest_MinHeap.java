public class Solution {
  
  // O(n) + kLog(n)
  public int[] kSmallest(int[] array, int k) {
    // O(n)
    ArrayList<Integer> arrayCopy = new ArrayList<Integer>();
    for (int elem : array) {
      arrayCopy.add(elem); 
    }
    
    // O(n)
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arrayCopy);
    int[] result = new int[k];
    for (int i = 0; i< k; i++) {
      // O(logn)
      result[i] = pq.poll(); 
    }
    return result;
  }
}
