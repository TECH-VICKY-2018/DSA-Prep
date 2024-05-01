package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysRepeatedElements {

    public static void RepeatedMissingUsingMap(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }

        int repeat = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    repeat = i;
                }
            } else {
                missing = i;
            }

            if (repeat != -1 && missing != -1) {
                break;
            }
        }

        System.out.println("RepeatedMissingUsingMap\nRepeat : " + repeat + " | Missing: " + missing);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i))
                .entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void printRepeating(int[] arr, int size) {
        int xor = 0;
        int set_bit_no;
        int n = size - 2;
        int x = 0, y = 0;

        for (int i = 0; i < size; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        set_bit_no = (xor & ~(xor - 1));

        for (int i = 0; i < size; i++) {
            if ((arr[i] & set_bit_no) != 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        System.out.print("Repeating elements are ");
        System.out.println(x + " " + y + " using XOR");
    }
    

    public static void repeatedElementsUsingArrayIndex(int[] nums, int n) {
        System.out.print("Repeated elements found using Array Index are :");
        for (int i = 0; i < n; i++) {
            int abs_val = Math.abs(nums[i]);
            if (nums[abs_val] > 0) {
                nums[abs_val] = -nums[abs_val];
            } else {
                System.out.print(" " + i);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};
        RepeatedMissingUsingMap(arr);
        System.out.println("-----------------------\n");

        int[] nums = {1, 2, 3, 4, 5, 2, 6, 7, 8, 9, 9};
        List<Integer> two_duplicates = findDuplicates(nums);
        System.out.println("Two Duplicates using stream : " + two_duplicates);
        System.out.println("---------------------------\n");

        int[] arr2 = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr2.length;
        printRepeating(arr2, arr_size);
        repeatedElementsUsingArrayIndex(arr2, arr_size);


    }
}
