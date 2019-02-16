public class Solution {
  public long fiboHelper(int K, long beforePrev, long prev) {
    
    for (int i = 2; i < K; i++) {
      long temp = prev;
      prev += beforePrev;
      beforePrev = temp;
    }
    return prev + beforePrev;
  }
  
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0; 
    } else if (K == 1) {
      return 1; 
    } else {
      return fiboHelper(K, 0, 1); 
    }
  }
}
