package TagedByCompany.DropBoxTag;

/**
 * @leetcode https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * @Time N
 * @Space 60
 */
public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] modRecord = new int[60];
        int total = 0;
        for (int num : time) {
            int mod = num % 60;
            int diff = (60 - mod) % 60;
            total += modRecord[diff];
            modRecord[mod]++;
        }
        return total;
    }
}
