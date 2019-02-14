public class Solution {
  public boolean areEqual(double x, double y) {
    boolean b = false;//complete the expression
    if(Math.abs(x - y) <= 0.0001) {
     b = true; 
    }
    return b;
  }
}
