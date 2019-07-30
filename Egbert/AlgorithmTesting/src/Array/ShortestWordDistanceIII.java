package Array;

/**
 * @leetcode https://leetcode.com/problems/shortest-word-distance-iii/
 * @date 29/7/2019
 * @Time n * m
 * @sapce 1
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int word1Index = -1;
        int word2Index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && words[i].equals(word2)) {
                if (word1Index != -1) {
                    min = Math.min(min, i - word1Index);
                }
                word1Index = i;
                word2Index = i;
            } else if (words[i].equals(word1)) {
                if (word2Index >= 0) {
                    min = Math.min(Math.abs(i - word2Index), min);
                }
                word1Index = i;
            } else if (words[i].equals(word2)) {
                if (word1Index >= 0) {
                    min = Math.min(Math.abs(i - word1Index), min);
                }
                word2Index = i;
            }
        }
        return min;
    }
}
