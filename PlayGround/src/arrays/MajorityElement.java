package arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        int n = nums.length;
        int count = 0;
        int element = -1;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == element) count++;
        }

        if (count > n / 2) return element;

        return -1;

    }

}
