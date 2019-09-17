package Facebook;

//As given in the question, we have to print english
//        words corresponding to number. For example:
//        124 as one hundred twenty four.
//        So, what if we want to print the number in reverse
//        order without reversing the number itself.
//        For example, in this case : 124 will be given as input
//        and output should be four hundred twenty one?
//        Constraint here is you are not allowed to reverse the number.

/**
 * @leetcode https://leetcode.com/problems/integer-to-english-words/discuss/216295/Follow-up-on-this-question
 * @Time length of number
 * @Space
 */
public class IntegerToEnglishWordBackward {
    private final String[] belowTen = new String[] {
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine"
    };

    private final String[] belowTwenty = new String[] {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] belowHundred = new String[] {
            "", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static void main(String[] args) {
        int[] input = new int[] {
            0, 8, 10,11,12,13,31,41, 131, 120, 1234, 1230, 12345, 123456, 1234567, 12345678,
            123456789, 1234567891
        };

        IntegerToEnglishWordBackward ite = new IntegerToEnglishWordBackward();
        for (int num : input) {
            System.out.println(ite.numberToWords(num));
        }
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num);
    }

    public String helper(int num) {
        String result = "";
        int length = (num + "").length();

        if (num < 10) {
            return belowTen[num];
        } else if (length < 3) {
            int d1 = num / 10;
            int d2 = num % 10;

            if (d2 == 1) {
                return belowTwenty[d1];
            } else {
                return belowHundred[d2] + " " + belowTen[d1];
            }
        } else if (length == 3) {
            // 123
            result = belowTen[num % 10] + " Hundred " + helper(num / 10);
        } else if (length == 4) {
            // 1,234
            result = belowTen[num % 10] + " Thousand " + helper(num / 10);
        } else if (length == 5) {
            // 123,45
            result = helper(num % 100) + " Thousand " + helper(num / 100);
        } else if (length == 6) {
            // 123,456
            result = helper(num % 1000) + " Thousand " + helper(num / 1000);
        } else if (length == 7) {
            // 123,456,7
            result = belowTen[num % 10] + " Million " + helper(num / 10);
        } else if (length == 8) {
            // 123,456,78
            result = helper(num % 100) + " Million " + helper(num / 100);
        } else if (length == 9) {
            // 123,456,789
            result = helper(num % 1000) + " Million " + helper(num / 1000);
        } else if (length == 10) {
            // 112,345,678,9
            result = helper(num % 10) + " Billion " + helper(num / 10);
        } else if (length == 11) {
            result = helper(num % 100) + " Billion " + helper(num / 100);
        } else if (length == 12) {
            result = helper(num % 1000) + " Billion " + helper(num / 1000);
        }

        return  result.trim();
    }
}
