package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSm {
    public static class NumIndex {
        int num;
        int index;

        public NumIndex(int n, int i) {
            this.num = n;
            this.index = i;
        }

        @Override
        public String toString() {
            return "NumIndex{" +
                    "num=" + num +
                    ", index=" + index +
                    '}';
        }
    }

    public class NumIndexComparator implements Comparator<NumIndex> {
        @Override
        public int compare(NumIndex o1, NumIndex o2) {
            return o1.num - o2.num;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        NumIndex[] numIndex = new NumIndex[n];

        for (int i = 0; i < n; i++) {
            numIndex[i] = new NumIndex(nums[i], i);
        }

        Arrays.sort(numIndex, new NumIndexComparator());

        int l = 0, r = n - 1;

        int[] res = new int[2];

        while (l <= r) {

            NumIndex leftIndex = numIndex[l];
            NumIndex rightIndex = numIndex[r];

            if (leftIndex.num + rightIndex.num < target) {
                l++;
            } else if (leftIndex.num + rightIndex.num > target) {
                r--;
            } else {
                res[0] = leftIndex.index;
                res[1] = rightIndex.index;
                break;
            }

        }

        return res;

    }

    public static void main(String[] args) {
        TwoSm twoSm = new TwoSm();
        int[] nums = {3, 1, 5, 2, 7, 8};
        int[] ans = twoSm.twoSum(nums, 4);
        System.out.println(Arrays.toString(ans));
    }
}
