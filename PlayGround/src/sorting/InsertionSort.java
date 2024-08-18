package sorting;

import java.util.Arrays;

public class InsertionSort {

    // Insertion Sort
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        // Traverse through the array
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Swap elements till we reach greater element
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public static void main(String[] args) {
        // Create an instance of solution class
        InsertionSort insertionSort = new InsertionSort();

        int[] nums = {13, 46, 24, 52, 20, 9};

        System.out.println("Before Using Insertion Sort: " + Arrays.toString(nums));

        // Function call for insertion sort
        nums = insertionSort.insertionSort(nums);

        System.out.println("After Using Insertion Sort: " + Arrays.toString(nums));
    }
}

