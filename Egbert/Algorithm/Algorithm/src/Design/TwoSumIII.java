package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * @date 29/7/2019
 * @Time O 1 for add, N for find worst
 */
public class TwoSumIII {
    List<Integer> input;
    Map<Integer, Integer> map;
    public TwoSumIII() {
        input = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.get(number) == null) {
            input.add(number);
        }
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == value - input.get(i)) {
                if (map.get(input.get(i)) > 1) {
                    return true;
                }
            } else {
                if (map.get(value - input.get(i)) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIII twosum = new TwoSumIII();
        twosum.add(0);
        twosum.add(0);
        System.out.println(twosum.find(0));
    }
}
