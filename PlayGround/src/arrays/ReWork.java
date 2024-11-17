package arrays;

import java.util.Arrays;

public class ReWork {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int max = 0;
        int cnt = 0;

        for (int num : nums) {
            if (num == 1) {
                cnt++;
                max = Math.max(cnt, max);
            } else {
                cnt = 0;
            }
        }
        return max;
    }

    public static void leftRotate(int[] nums) {
        int n = nums.length;
        int temp = nums[0];

        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = temp;
    }

    public static void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, n - k - 1);
        reverseArray(nums, n - k, n - 1);

    }

    public static void moveZeroes(int[] nums) {

        int n = nums.length;

        int j = 0;

        for(int i=0; i<n; i++){
            if(nums[i]!=0){
                if(i!=j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 3, 4, 0, 0, 7, 0, 9};
        System.out.println("max ones : " + findMaxConsecutiveOnes(nums));
        moveZeroes(nums);
        System.out.println("Rotate : " + Arrays.toString(nums));

    }
}

