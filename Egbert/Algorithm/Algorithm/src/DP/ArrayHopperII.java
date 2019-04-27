package DP;

public class ArrayHopperII {
    // M[i] represents minimum steps from 0th index to
    // ith index
    public int minJump(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int[] minJump = new int[array.length];
        minJump[0] = 0;
        for (int i = 1; i < array.length; i++) {
            minJump[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1) {
                    if (minJump[j] + 1 < minJump[i] || minJump[i] == -1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[minJump.length - 1];
    }

    // M[i] stands for the minimum steps that from ith index
    // to the end
    public int minJumpDPII(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int[] minJump = new int[array.length];
        minJump[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                minJump[i] = 1;
            } else {
                int minStep = Integer.MAX_VALUE;
                for (int j = array[i]; j >= 1; j--) {
                    if (minJump[i + j] > 0) {
                        minStep = Math.min(minStep, minJump[i + j]);
                    }
                }
                if (minStep > 0) {
                    minJump[i] = minStep + 1;
                }
            }
        }
        return minJump[0] <= 0 ? -1 : minJump[0];
    }
}
