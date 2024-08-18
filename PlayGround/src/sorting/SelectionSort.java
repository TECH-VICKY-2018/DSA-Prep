package sorting;

public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        Swap s = new Swap();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        return nums;
    }
}
