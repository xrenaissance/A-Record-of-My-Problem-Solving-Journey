package Sort;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/high-five/
 * @Time nlogn
 * @Space number of distinct id
 */
public class HighFive {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Arrays.sort(results, (r1, r2) -> {
            if (r1.id == r2.id) {
                return r2.score - r1.score;
            }
            return r1.id - r2.id;
        });
        Map<Integer, Double> res = new HashMap<>();
        double count = 0;
        double total = 0;
        int i = 0;
        while (i < results.length) {
            if (count < 5) {
                total += results[i++].score;
                count++;
            } else {
                res.put(results[i - 1].id, total/5.0);
                count = 0;
                total = 0;
                while (i < results.length && results[i].id == results[i - 1].id) {
                    i++;
                }
            }
        }
        if (total != 0) {
            res.put(results[i - 1].id, total/5.0);
        }
        return res;
    }
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a1, a2) -> {
                    int id1 = a1[0];
                    int id2 = a2[0];
                    if (id1 == id2) {
                        return a2[1] - a1[1];
                    }
                    return id1 - id2;
                }
        );
        int count = 0;
        int total = 0;
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < items.length) {
            if (count < 5) {
                total += items[i++][1];
                count++;
            } else {
                res.add(Arrays.asList(items[i - 1][0], total/5));
                total = 0;
                count = 0;
                while(i < items.length && items[i][0] == items[i - 1][0]) {
                    i++;
                }
            }
        }
        if (total != 0) {
            res.add(Arrays.asList(items[items.length - 1][0], total/5));
        }
        int[][] output = new int[res.size()][2];
        int j = 0;
        for (List<Integer> list : res) {
            output[j][0] = list.get(0);
            output[j][1] = list.get(1);
            j++;
        }
        return output;
    }
    public static void main(String[] args) {
        int[][] items = new int[][] {{1,91},{1,92},{2,93},
        {2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        Arrays.sort(items, (a1, a2) -> {
                    int id1 = a1[0];
                    int id2 = a2[0];
                    if (id1 == id2) {
                        return a2[1] - a1[1];
                    }
                    return id1 - id2;
                }
        );
        for (int[] item : items) {
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
