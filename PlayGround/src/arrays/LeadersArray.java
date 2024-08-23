package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersArray {


    public int[] leaders(int[] nums) {

        int n = nums.length;

        int i = n - 1;
        int j = n - 2;

        List<Integer> resList = new ArrayList<>();

        resList.add(nums[i]); //right most element

        while (j >= 0) {
            if (nums[j] > nums[i]) {
                resList.add(nums[j]);
                i = j;
            }

            j--;
        }

        int s = resList.size();

        int[] resNum = new int[s];

        int k = 0;
        for(int l = s-1; l>=0; l--){
            resNum[l] = resList.get(k);
            k++;
        }

        return resNum;

    }

    public static void main(String[] args) {
        LeadersArray obj = new LeadersArray();
        int[] arr = {-3, 4, 5, 1, -30, -10};

        int[] result = obj.leaders(arr);
        Arrays.stream(result).forEach((int x) -> System.out.print(x + " "));
    }
}
