package arrays;

public class KadanesAlgo {

    public int maxSubArrayBrute(int[] nums) {

        int n = nums.length;

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += nums[j];

                maxi = Math.max(sum, maxi);

            }

        }
        return maxi;
    }

    public int maxSubArray(int[] nums) {

        int n = nums.length;

        long maxi = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }

        }
        return (int) maxi;
    }

}
