package arrays;

import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeating {

    public int[] findMissingRepeatingNumbersBtr(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int repeating = -1, missing = -1;

        for (int i = 1; i < n + 1; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    repeating = i;
                }
            } else {
                missing = i;
            }
        }

        return new int[]{repeating, missing};
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {

        int n = nums.length;

        long repeating;
        long missing;

        long sArr = 0;
        long s2Arr = 0;

        for (int i = 0; i < n; i++) {
            sArr += nums[i];
            s2Arr += (long) Math.pow(nums[i], 2);
        }

        long sN = (n * (n + 1)) / 2;
        long s2N = (n * (n + 1) * (2 * n + 1)) / 6;

        long val1 = (s2N - s2Arr) / (sN - sArr);
        long val2 = sN - sArr;

        repeating = (val1 - val2) / 2;

        missing = val1 - repeating;


        return new int[]{(int) repeating, (int) missing};
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};

        // Create an instance of Solution class
        MissingAndRepeating sol = new MissingAndRepeating();

        int[] result = sol.findMissingRepeatingNumbers(nums);

        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
    }


}
