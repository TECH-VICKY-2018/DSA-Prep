package arrays;

public class Sort012 {

    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortZeroOneTwo(int[] nums) {

        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid < high) {

            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};
        sortZeroOneTwo(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

}
