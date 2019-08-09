package Math;
import java.util.Set;
import java.util.HashSet;

/**
 * @lintcode 180 https://www.lintcode.com/problem/binary-representation/description?_from=ladder&&fromId=14
 * @Time log N
 * @Space 1
 */
public class BinaryRepresentation {
    /**
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
    public static String binaryRepresentation(String n) {
        if (n == null || n.length() == 0) {
            return "";
        }
        if (n.indexOf('.') == -1) {
            return parseInt(n);
        }
        String[] array = n.split("\\.");
        StringBuilder res = new StringBuilder();
        String floatPart = parseFloat(array[1]);
        if (floatPart.equals("ERROR")) {
            return floatPart;
        }
        String intPart = parseInt(array[0]);
        if (floatPart.equals("") || floatPart.equals("0")) {
            return intPart;
        }
        return res.append(intPart).append('.').
                append(floatPart).toString();
    }
    private static String parseInt(String s) {
        if (s.equals("") || s.equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        int num = Integer.parseInt(s);
        while (num != 0) {
            res.append(num % 2);
            num /= 2;
        }
        res.reverse();
        return res.toString();
    }
    private static String parseFloat(String s) {
        double num = Double.parseDouble("0." + s);
        Set<Double> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (res.length() > 32 || set.contains(num)) {
                return "ERROR";
            }
            set.add(num);
            num *= 2;
            if (num >= 1) {
                res.append(1);
                num -= 1;
            } else {
                res.append(0);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String input = "3.72";
        //System.out.println(BinaryRepresentation.binaryRepresentation(input));
        //System.out.println(BinaryRepresentation.binaryRepresentation("123.98"));
        //System.out.println(BinaryRepresentation.binaryRepresentation("3.5"));
        System.out.println(BinaryRepresentation.binaryRepresentation("28187281.128121212121"));
    }
}
