package arrays;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    public int reversePairs(int[] nums) {

        int n = nums.length;
        return reversePairMergeSortHelper(nums, 0, n - 1);
    }

    private int reversePairMergeSortHelper(int[] nums, int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;
            count += reversePairMergeSortHelper(nums, low, mid);
            count += reversePairMergeSortHelper(nums, mid + 1, high);
            count += countReversePair(nums, low, mid, high);
            merge(nums, low, mid, high);
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        List<Integer> currSortedList = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                currSortedList.add(nums[left]);
                left++;
            } else {
                currSortedList.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            currSortedList.add(nums[left]);
            left++;
        }

        while (right <= high) {
            currSortedList.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = currSortedList.get(i - low);
        }
    }

    private int countReversePair(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2 * nums[right]) right++;

            count += right - (mid + 1);
        }
        return count;
    }
}
