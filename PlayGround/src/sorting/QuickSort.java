package sorting;

import java.util.Arrays;

public class QuickSort {

    private int getPartitionIndex(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start + 1, j = end;

        while (i <= j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }

            if (i < j) {
                // Swap nums[i] and nums[j]
                nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
            }
        }

        // Swap pivot with nums[j] (the final position of the pivot)
        nums[start] = nums[j];
        nums[j] = pivot;

        return j;
    }

    private void quickSortHelper(int[] nums, int start, int end) {
        if (start < end) {
            int partitionIndex = getPartitionIndex(nums, start, end);
            quickSortHelper(nums, start, partitionIndex - 1);
            quickSortHelper(nums, partitionIndex + 1, end);
        }
    }

    public int[] quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        // Create an instance of solution class
        QuickSort quickSort = new QuickSort();

        int[] nums = {13, 46, 24, 52, 20, 9};

        System.out.println("Before Using Quick Sort: " + Arrays.toString(nums));

        // Function call for insertion sort
        nums = quickSort.quickSort(nums);

        System.out.println("After Using Quick Sort: " + Arrays.toString(nums));
    }
}

