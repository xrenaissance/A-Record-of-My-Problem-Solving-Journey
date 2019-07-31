package Math;

/**
 * @leetcode https://leetcode.com/problems/nim-game/
 * @Time 1
 * @Space 1
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
