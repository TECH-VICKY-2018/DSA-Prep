package arrays;

public class RearrangeArraY {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];
        int i = 0, j = 1;
        for (int x : nums) {
            if (x >= 0) {
                ans[i] = x;
                i = i + 2;
            } else {
                ans[j] = x;
                j = j + 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, -4, -2, -9, 2, 3};

        RearrangeArraY obj = new RearrangeArraY();
        int[] ans = obj.rearrangeArray(arr);

        for (int x : ans) {
            System.out.printf(x + " ");
        }

    }
}
