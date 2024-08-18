package arrays;

public class ZerosToEnd {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0; // Pointer to track the position of the next non-zero position in the array

        // Iterate through the array with the first pointer
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // Swap only when i and j are different
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++; // Move the j pointer to the next position
            }
        }

    }

}
