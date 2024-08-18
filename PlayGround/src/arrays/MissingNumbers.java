package arrays;

import java.util.Arrays;

public class MissingNumbers {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        for (int i = 0; i <= n; i++) {

            boolean isMissing = true;

            for (int num : nums) {
                if (i == num) {
                    isMissing = false;
                    break;
                }
            }

            if (isMissing) return i;

        }

        return -1;


    }

    public int missingNumberBetter(int[] nums) {

        int n = nums.length;
        int sumOfN = 0;

        for (int i = 0; i <= n; i++) {
            sumOfN += i;
        }

        int sumOfArrElements = 0;

        for (int num : nums) {
            sumOfArrElements += num;
        }

        return sumOfN - sumOfArrElements;

    }

    public int missingXor(int[] nums) {
        int n = nums.length;

        int missing = 0;

        for (int i = 0; i <= n; i++) {
            missing ^= i;
        }

        for (int num : nums) {
            missing ^= num;
        }

        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 5, 3, 4, 6};

        MissingNumbers missingNumbers = new MissingNumbers();

        System.out.println("Missing number: " + missingNumbers.missingXor(nums));
    }
}
