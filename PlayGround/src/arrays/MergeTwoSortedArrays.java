package arrays;

public class MergeTwoSortedArrays {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int len = m + n;
        int gap = len / 2 + len % 2;

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                if (left < m && right >= m) {
                    swapGreater(nums1, nums2, left, right - m);
                } else if (left >= m) {
                    swapGreater(nums2, nums2, left - m, right - m);
                } else {
                    swapGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }

            if (gap == 1) break;
            gap = gap / 2 + gap % 2;
        }

        if (len - m >= 0) System.arraycopy(nums2, 0, nums1, m, len - m);

    }

    private void swapGreater(int[] nums1, int[] nums2, int ind1, int ind2) {

        if (nums1[ind1] > nums2[ind2]) {
            int temp = nums1[ind1];
            nums1[ind1] = nums2[ind2];
            nums2[ind2] = temp;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {0, 2, 7, 8, 0, 0, 0};
        int[] nums2 = {-7, -3, -1};
        int m = 4, n = 3;

        // Create an instance of the Solution class
        MergeTwoSortedArrays sol = new MergeTwoSortedArrays();

        sol.merge(nums1, m, nums2, n);

        // Output the merged arrays
        System.out.println("The merged array is:");
        System.out.print("nums1[] = ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
