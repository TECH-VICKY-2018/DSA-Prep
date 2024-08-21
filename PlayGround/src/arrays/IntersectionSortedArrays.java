package arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionSortedArrays {

    public int[] intersectionArrayBrute(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[m];

        for (int k : nums1) {
            for (int j = 0; j < m; j++) {

                if (nums2[j] == k && !vis[j]) {
                    res.add(nums2[j]);
                    vis[j] = true;
                    break;
                }

                if (nums2[j] > k) {
                    break;
                }
            }
        }

        int[] resArr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }

    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        ArrayList<Integer> resList = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                resList.add(nums2[j]);
                i++;
                j++;
            }
        }

        int[] res = new int[resList.size()];

        for (int k = 0; k < res.length; k++) {
            res[k] = resList.get(k);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 5, 6, 7};
        int[] nums2 = {3, 3, 4, 4, 5, 8};

        IntersectionSortedArrays obj = new IntersectionSortedArrays();

        int[] ans = obj.intersectionArray(nums1, nums2);

        for (int num : ans) {
            System.out.print(num + " ");
        }

    }
}
