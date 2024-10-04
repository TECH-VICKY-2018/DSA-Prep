package arrays;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> majorityElementTwo(int[] nums) {

        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;

        int candidate1 = -1;
        int candidate2 = -1;

        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2++;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count2--;
                count1--;
            }
        }

        count2 = 0;
        count1 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }

        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3 && candidate1!=candidate2) result.add(candidate2);

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2, 2, 2, 5};
        int[] nums2 = {-1,-1,-1};
        System.out.println(new MajorityElement().majorityElement(nums)); // Output: 2
        System.out.println(new MajorityElement().majorityElementTwo(nums2).toString());
    }

}
