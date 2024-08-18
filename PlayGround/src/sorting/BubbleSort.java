package sorting;

import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] nums, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

        int[] nums = {13, 20, 52, 24, 9};
        int n = nums.length;

        Arrays.stream(bubbleSort.bubbleSort(nums, n)).forEach(value -> System.out.print(value + " "));
    }
}
