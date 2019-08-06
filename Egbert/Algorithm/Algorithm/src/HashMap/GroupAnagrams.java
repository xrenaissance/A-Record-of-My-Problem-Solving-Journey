package HashMap;

import java.util.HashMap;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/group-anagrams/
 * @Time N * M log M
 * N = number of strings, M is average length of string
 * @Space M * N + D   M = average length of char Array
 * N = number of strings, D is number of EnetrySet
 */
public class GroupAnagrams {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> groups = new HashMap<>();
        // N
        for (String str : strs) {
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray); // M log M
            String convtedStr = new String(chArray);
            // O 1
            if (groups.get(convtedStr) == null) {
                groups.put(convtedStr, new ArrayList<String>());
            }
            groups.get(convtedStr).add(str);
        }
        // O D
        return new ArrayList<>(groups.values());
    }
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list1 = Arrays.asList("ate","eat","tea");
        List<String> list2 = Arrays.asList("bat");
        List<String> list3 = Arrays.asList("nat", "tan");
        map.put("aet", list1);
        map.put("bat", list2);
        map.put("ant", list3);
        List<List<String>> res = new ArrayList<>(map.values());
        for (List<String> list : res) {
            System.out.println(list.toString());
        }
        int[] array = new int[]{1,0,0,1,1,0,0,0,1,1,0,1,0,1};
        System.out.println(Arrays.toString(array));
    }
}
