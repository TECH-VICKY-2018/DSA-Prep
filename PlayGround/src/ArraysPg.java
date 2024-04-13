import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArraysPg {

    // Function that print the repeated element and the missing element in an array of n elements,
    // provided elements of the array are in range of [1,n]
    // Map Approach
    //https://leetcode.com/problems/find-missing-and-repeated-values/description/
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

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};
        RepeatedMissingUsingMap(arr);
        System.out.println("-----------------------\n");

        int[] nums = {1, 2, 3, 4, 5, 2, 6, 7, 8, 9, 9};
        List<Integer> two_duplicates = findDuplicates(nums);
        System.out.println("Two Duplicates using stream : " + two_duplicates);
        System.out.println("---------------------------\n");

    }
}

