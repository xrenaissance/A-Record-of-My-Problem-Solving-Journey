import java.util.ArrayList;
import java.util.List;
public class PermutationsTestII {
    public static List<String> subsetsII(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helperII(arraySet, sb, 0, result);
        return result;
    }
    public static void helperII(char[] set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        for (int i = index; i < set.length; i++) {
            System.out.println(i + "th --------------- " + "i = " + i + " index = " + index);
           sb.append(set[i]);
           helperII(set, sb, i + 1, result);
           sb.deleteCharAt(sb.length() - 1);
            System.out.println(i + "th return --------------- " + "i = " + i + " index = " + index);
        }
    }
}
