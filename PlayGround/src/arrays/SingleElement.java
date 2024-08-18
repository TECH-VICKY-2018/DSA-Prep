package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SingleElement {

    public static int singlelement(int n, List<Integer> arr) {
        // Write your code here
        int l = 1;
        int h = n - 2;

        if (n == 1) {
            return arr.getFirst();
        }

        if (!Objects.equals(arr.get(0), arr.get(1))) {
            return arr.getFirst();
        }

        if (!Objects.equals(arr.get(n - 1), arr.get(n - 2))) {
            return arr.get(n - 1);
        }

        while (l <= h) {
            int m = (l + h) / 2;

            if ((m == 0 || !Objects.equals(arr.get(m), arr.get(m - 1))) && (m == n - 1 || !Objects.equals(arr.get(m), arr.get(m + 1)))) {
                return arr.get(m);
            }

            if ((m % 2 == 1 && Objects.equals(arr.get(m), arr.get(m - 1))) || (m % 2 == 0 && Objects.equals(arr.get(m), arr.get(m + 1)))) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return -1;
    }

    public static int singleElementXor(int n, int[] nums) {

        int xorr = 0;

        for (int num : nums) {
            xorr ^= num;
        }


        return xorr;
    }

    public static int singleNumberMap(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (freq.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1001, 1001, 1009, 6, 1111, 1111, 1, 1, 3, 3, 1009, 8, 8);
        int n = 5;
        int[] num = {1001, 1001, 1009, 6, 1111, 1111, 1, 1, 3, 3, 1009, 8, 8};

        System.out.println(singlelement(n, arr));
        System.out.println("xor : " + singleElementXor(n, num));
        System.out.println("map : " + singleNumberMap(num));

    }
}
