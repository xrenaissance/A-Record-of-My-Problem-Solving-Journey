package DP;

public class ArrayHopperI {

    public boolean canJump(int[] array) {
        // canJump[i] means from index 0, can jump to index i.
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // if index j is reachable from index 0, and from index j
                // it is possible to jump to index i
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }

    // 0 1 2 3 4 1 6
    // M[i] = true if there is j that j <= i + array[i]
    // Base case: M[n - 1] = true
    // Induction rule: M[i] represents whether or not we can
    // jump to target from ith index
    // M[i] = true iff there is an element j where j <= i + input[i]
    // and M[j] = true otherwise false
    // Time: O(n ^ 2) --> O(n ^ k) where k is the min(n, largest value inj the array)
    public boolean canJumpDPII(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            } else {
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[i + j]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }
}
