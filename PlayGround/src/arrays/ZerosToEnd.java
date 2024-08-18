package arrays;

public class ZerosToEnd {

    public void moveZeroes(int[] nums) {
        int n = nums.length, i = 0, j = 1;

        while (i < n && j < n) {

            if (nums[i] == 0 && nums[j] == 0) {
                j++;
            }

            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }

        }

    }

}
