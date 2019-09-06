package StringI;

public class AllPermutationsII {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        permutations(array, 0, result);
        return result;
    }
    private void permutations(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
        }
        Set<Character> records = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!records.contains(array[i])) {
                records.add(array[i]);
                swap(array, index, i);
                permutations(array, index + 1, result);
                swap(array, index, i);
            }
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
