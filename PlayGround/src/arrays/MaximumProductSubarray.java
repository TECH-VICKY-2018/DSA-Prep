package arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int maxProduct = nums[0];
        int minProduct = nums[0];

        int result = nums[0];

        for (int i = 1; i < n; i++) {

            int currElement = nums[i];

            if (nums[i] < 0) {
                maxProduct = maxProduct + minProduct;
                minProduct = maxProduct - minProduct;
                maxProduct = maxProduct - minProduct;
            }

            maxProduct = Math.max(currElement, currElement * maxProduct);
            minProduct = Math.min(currElement, currElement * minProduct);

            result = Math.max(result, maxProduct);

        }

        return result;
    }
}
