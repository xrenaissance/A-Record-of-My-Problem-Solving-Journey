public class Solution {
  public boolean isPrime(int n) {
   int mid = n / 2;
   for (int i = 2; i <= mid; i++) {
    if (n % i == 0) {
     return false; 
    }
   }
    return true;
  }
}
