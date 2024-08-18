package arrays;

public class RotateArray {

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        //Create an instance of the Solution class
        RotateArray sol = new RotateArray();

        // Call the function to rotate the array
        sol.rotateArray(arr, k);

        System.out.println("After rotating the elements to the left: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
