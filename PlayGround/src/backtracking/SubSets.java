package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void generateAllSubsets(int[] nums, List<Integer> subSet, int index) {


        if (index == nums.length) {
            System.out.print(subSet + " ");
            return;
        }

        //notTake
        generateAllSubsets(nums, subSet, index + 1);

        //take
        subSet.add(nums[index]);
        generateAllSubsets(nums, subSet, index + 1);
        subSet.remove(subSet.size() - 1);

    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5};

        generateAllSubsets(arr, new ArrayList<>(), 0);
    }
}
