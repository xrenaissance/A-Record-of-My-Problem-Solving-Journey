package GoogleTag;

public class LaiCodeMissingNumber {
    public int missingBit(int[] array) {
        int res = array.length + 1;
        for (int i = 0; i < array.length; i++) {
            res ^= (i + 1);
            res ^= array[i];
        }
        return res;
    }
}
