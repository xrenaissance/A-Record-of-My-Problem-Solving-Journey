package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/strobogrammatic-number/
 * @Time n
 * @Space 1
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left++);
            char rightChar = num.charAt(right--);
            if (map.get(leftChar) == null || map.get(leftChar) != rightChar) {
                return false;
            }
        }
        return true;
    }
}
