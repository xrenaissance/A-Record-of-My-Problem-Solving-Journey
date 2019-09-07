package Facebook;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        int[] right = new int[nums.length];
        int product = nums[0];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] input = new int[] {1, 2, 3, 4};
        p.productExceptSelf(input);
    }
}
