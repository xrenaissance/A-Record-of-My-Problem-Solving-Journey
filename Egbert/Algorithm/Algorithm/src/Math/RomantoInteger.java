package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/roman-to-integer/
 * @date 24/7/2019
 * @Time N
 * @Space 7
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> chToIntMap = new HashMap<>();
        chToIntMap.put('I', 1);
        chToIntMap.put('V', 5);
        chToIntMap.put('X', 10);
        chToIntMap.put('L', 50);
        chToIntMap.put('C', 100);
        chToIntMap.put('D', 500);
        chToIntMap.put('M', 1000);
        int slow = 0;
        int fast = 1;
        int sum = 0;
        while (fast < s.length()) {
            int slowNum = chToIntMap.get(s.charAt(slow++));
            int fastNum = chToIntMap.get(s.charAt(fast++));
            if (slowNum >= fastNum) {
                sum += slowNum;
            } else {
                sum -= slowNum;
            }
        }
        return sum + chToIntMap.get(s.charAt(slow));
    }
}
