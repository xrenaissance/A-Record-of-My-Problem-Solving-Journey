package Math;

public class PowerOfTen {
    // (9 + 1) ^ n - 1 = 9 ^ n + 9 ^ n-1 + 9 ^ n-2 +..+ 1-1 % 9 ==0
    public static boolean isPowerOfTen(int n) {
        return n % 10 == 0 && (n - 1) % 9 == 0;
    }
    public static void main(String[] args) {
        System.out.println(PowerOfTen.isPowerOfTen(10));
        System.out.println(PowerOfTen.isPowerOfTen(100));
        System.out.println(PowerOfTen.isPowerOfTen(1000));
        System.out.println(PowerOfTen.isPowerOfTen(10000));
        System.out.println(PowerOfTen.isPowerOfTen(100000));
        System.out.println(PowerOfTen.isPowerOfTen(970));
        System.out.println(PowerOfTen.isPowerOfTen(99990));
    }
}
