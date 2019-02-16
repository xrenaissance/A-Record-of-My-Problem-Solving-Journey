public class Solution {
  public long factHelper(int n, long result) {
    if (n == 0){
      return 1; 
    }
    for (int i = 1; i <= n; i++) {
      result *= i; 
    }
    return result;
  }
  
  public long factorial(int n) {
    return factHelper(n, 1);
  }
}
