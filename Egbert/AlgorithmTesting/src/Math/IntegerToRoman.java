package Math;

/**
 * @leetcode https://leetcode.com/problems/integer-to-roman/
 * @date 24/7/2019
 * @Time 4
 * @Space 35
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        String[] M = new String[] {"", "M", "MM", "MMM"}; // 0- 1000 - 3000
        // 0 - 100 - 900
        String[] C = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC","CM"};
        // 0 - 10 -90
        String[] X = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 0 -1- 9
        String[] I = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return new StringBuilder().
                append(M[num / 1000]).
                append(C[(num % 1000) / 100]).
                append(X[(num % 100) / 10]).
                append(I[num % 10]).toString();
    }
    public static void main(String[] args) {
        System.out.println(IntegerToRoman.intToRoman(3));
        System.out.println(IntegerToRoman.intToRoman(4));
        System.out.println(IntegerToRoman.intToRoman(58));
        System.out.println(IntegerToRoman.intToRoman(1994));
    }
}
