package HashMap;

import java.util.HashMap;
import java.util.*;
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * @leetcode https://leetcode.com/problems/insert-delete-getrandom-o1/
 * @Time 1
 * @Space N + N
 */
public class InsertDeleteGetRandomO1 {
    Map<Integer, Integer> valMap;
    List<Integer> array;
    Random random;
    int size;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        valMap = new HashMap<>();
        array = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valMap.get(val) == null) {
            array.add(val);
            valMap.put(val, size);
            size++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valMap.get(val) != null) {
            int removedIndex = valMap.get(val);
            int lastValue = array.get(size - 1);

            valMap.put(lastValue, removedIndex);
            array.set(removedIndex, lastValue); // swap (lastIndex, removedIndex)
            valMap.remove(val);
            array.remove(size - 1);
            this.size--;
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(random.nextInt(size));
    }
}
