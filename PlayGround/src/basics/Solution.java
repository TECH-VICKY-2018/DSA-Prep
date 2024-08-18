package basics;

class Solution {

    private void rotateArrayByOne(int[] nums) {

        int first = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = first;
    }

    public void rotateArray(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            rotateArrayByOne(nums);
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Solution solution = new Solution();
        solution.rotateArrayByOne(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
