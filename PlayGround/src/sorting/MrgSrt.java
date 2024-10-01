package sorting;

import java.util.ArrayList;
import java.util.List;

public class MrgSrt {


    public int[] mergeSort(int[] nums) {

        int n = nums.length;

        mergeSortHelper(nums, 0, n - 1);

        return nums;

    }

    private void mergeSortHelper(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSortHelper(nums, low, mid);
        mergeSortHelper(nums, mid + 1, high);
        merge(low, mid, high, nums);
    }

    private void merge(int low, int mid, int high, int[] nums) {

        int left = low;
        int right = mid + 1;

        List<Integer> tempList = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                tempList.add(nums[left]);
                left++;
            } else {
                tempList.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            tempList.add(nums[left]);
            left++;
        }

        while (right <= high) {
            {
                tempList.add(nums[right]);
                right++;
            }
        }

        for (int i = low; i <= high; i++) {
            nums[i] = tempList.get(i - low);
        }

    }


}
