public class Solution {
  public long power(int a, int b) {
    long result = 1;
    if (b == 0 && a != 0 || a == 1) {
      return 1; 
    }
    for(int i = 0; i < b/2; i++) {
      result *= a; 
    }
    if(b % 2 == 1) {
      return result * result * a;
    }
    return result * result;
  }
}
