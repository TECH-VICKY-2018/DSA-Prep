package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates {

    public int removeDuplicatesNaive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
                list.add(nums[i]);
            }
        }

        int dupCount = map.size();

        for (int i = 0; i < dupCount; i++) {
            nums[i] = list.get(i);
        }
        for (int i = dupCount; i < n; i++) {
            nums[i] = 0;
        }


        return map.size();

    }

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;

    }

    public static void main(String[] args) {

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        int[] nums = {1, 1, 3, 3, 3, 3, 2, 2, 4, 4, 4, 5};

        int length = removeDuplicates.removeDuplicates(nums);
        System.out.println("Length of the array after removing duplicates: " + length);
    }
}
