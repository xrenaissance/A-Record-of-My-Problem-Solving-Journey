import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*



 */
public class LintCodeMainStub {

    public static int solution(int[] nums, int target)
            throws IOException {


        int pl, pr;

        int count = 0;

        Arrays.sort(nums);

        for (pr = nums.length - 1; pr > 0; pr--) {
            for (pl = 0; pl < pr; pl++) {
                if (nums[pl] + nums[pr] > target) {
                    count += pr - pl;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        int[] nums = {1, 2, 5, 6, 7, 3, 5, 8, -33, -5, -72, 12, -34, 100, 99};

        int target = -64;

        System.out.println(solution(nums, target));
    }
}



