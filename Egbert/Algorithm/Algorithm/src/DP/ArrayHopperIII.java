package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * Time: O(N ^ 2) worst
 * Space: O(N)
 */
public class ArrayHopperIII {
    // M[i] represents the minimum steps that jump from ith index to out of the array
    public int minJump(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] minJump = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (i + array[i] >= array.length) {
                minJump[i] = 1;
            } else {
                for (int j = array[i]; j >= 1; j--) {
                    if (minJump[i + j] > 0 && (minJump[i] == 0 ||
                            minJump[i + j] + 1 < minJump[i])) {
                        minJump[i] = minJump[i + j] + 1;
                    }
                }
            }
        }
        return minJump[0] == 0 ? -1 : minJump[0];
    }
}
