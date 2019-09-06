package Subsets;
import java.util.ArrayList;
import java.util.List;
public class FourOutOfT {
    public static int chooseDP(int n) {
        int[][] dp = new int[4 + 1][n + 1];
        return n;
    }
    public static int choolse(int n, int k) {
        if (n <= 4) {
            return 0;
        }
        List<Integer> currLayer = new ArrayList<>();
        int[] total = new int[1];
        dfs(n, 0, k, currLayer, total);
        return total[0];
    }
    private static void dfs(int n, int level, int size,
                     List<Integer> currLayer,
                     int[] total) {
        if (currLayer.size() == size) {
            total[0]++;
            return;
        }
        for (int i = level; i < n; i++) {
            if (i > 0 && currLayer.size() > 0
                   && i == currLayer.get(currLayer.size() - 1) + 1) {
                continue;
            }
            currLayer.add(i);
            dfs(n, i + 1, size, currLayer, total);
            currLayer.remove(currLayer.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(FourOutOfT.choolse(20, 4));
        System.out.println(FourOutOfT.choolse(10, 2));
    }
}
