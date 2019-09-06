public class aToPowerb {
    public double power(int a, int b) {
       if (a == 0 && b == 0) {
          return 0;
       } else if (a == 0 && b < 0) {
          return 0;
       } else if (b == 0) {
           return 1;
       } else if (b < 0) {
           return 1/power(a, b);
       }
        return 1;
    }
}
