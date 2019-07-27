package Math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/basic-calculator/
 * @date 27/7/2019
 * @Time N
 * @Space N
 */
public class BasicCalculator {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sign = 1;
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = (s.charAt(i) - '0');
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.offerLast(result);
                stack.offerLast(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pollLast() + stack.pollLast();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String input1 = " 2 - 1   + 2  ";
        String input2 = "(1+(4+5+2)-3)+(6+8)";
        String input3 = "1 + 1 - (2 + 1) - 10";
        String input4 = "1 - (5)";
        System.out.println(BasicCalculator.calculate(input1));
        System.out.println(BasicCalculator.calculate(input2));
        System.out.println(BasicCalculator.calculate(input3));
        System.out.println(BasicCalculator.calculate(input4));
    }
}
//   (1+(4+5+2)-3)+(6+8)