package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> tempSegmentList = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                tempSegmentList.add(nums[left]);
                left++;
            } else {
                tempSegmentList.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            tempSegmentList.add(nums[left]);
            left++;
        }
        while (right <= high) {
            tempSegmentList.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = tempSegmentList.get(i - low);
        }
    }



    private int[] mergeSortHelper(int[] nums, int low, int high) {
        if (low >= high) return nums;

        int mid = low + ((high - low) / 2);

        mergeSortHelper(nums, low, mid);
        mergeSortHelper(nums, mid + 1, high);

        merge(nums, low, mid, high);

        return nums;
    }


    public int[] mergeSort(int[] nums) {

        int n = nums.length;
        return mergeSortHelper(nums, 0, n - 1);

    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int n = arr.length;

        System.out.println("Before Sorting Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Function call to sort the array
        int[] sortedArr = mergeSort.mergeSort(arr);

        System.out.println("After Sorting Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sortedArr[i] + " ");
        }
        System.out.println();

    }
}
