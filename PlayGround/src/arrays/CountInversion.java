package arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {

    public long numberOfInversionsBrute(int[] nums) {

        int n = nums.length;

        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;

    }

    public long numberOfInversions(int[] nums) {

        int n = nums.length;

        return mergeSort(nums, 0, n - 1);


    }

    private long mergeSort(int[] nums, int low, int high) {

        long count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);

            count += merge(nums, low, mid, high);


        }

        return count;
    }

    private long merge(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        long count = 0;

        List<Integer> currSorted = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                currSorted.add(nums[left]);
                left++;
            } else {
                currSorted.add(nums[right]);
                right++;
                count += (mid - left) + 1;
            }
        }

        while (left <= mid) {
            currSorted.add(nums[left]);
            left++;
        }

        while (right <= high) {
            currSorted.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = currSorted.get(i - low);
        }


        return count;
    }

}
