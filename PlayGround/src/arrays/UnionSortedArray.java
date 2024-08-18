package arrays;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UnionSortedArray {

    private static int nextDistinct(int[] nums, int currIndex, int size) {

        while (currIndex < size - 1 && nums[currIndex] == nums[currIndex + 1]) {
            currIndex++;
        }

        return currIndex + 1;

    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // add your code here
        ArrayList<Integer> unionResult = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                unionResult.add(arr1[i]);
                i = nextDistinct(arr1, i, n);
            } else if (arr1[i] > arr2[j]) {
                unionResult.add(arr2[j]);
                j = nextDistinct(arr2, j, m);
            } else {
                unionResult.add(arr1[i]);
                i = nextDistinct(arr1, i, n);
                j = nextDistinct(arr2, j, m);
            }

        }

        while (i < n) {
            unionResult.add(arr1[i]);
            i = nextDistinct(arr1, i, n);
        }

        while (j < m) {
            unionResult.add(arr2[j]);
            j = nextDistinct(arr2, j, m);
        }

        return unionResult;
    }

    public static void main(String[] args) {
        UnionSortedArray obj = new UnionSortedArray();

        int[] arr1 = {-8, -3, -3, -2, 0, 1, 2, 2, 6};
        int[] arr2 = {-9, -8, -3, -2, 0, 1, 2, 6};

        List<Integer> res = obj.findUnion(arr1, arr2, arr1.length, arr2.length);


        Arrays.stream(arr1).forEach((int x) -> {
            System.out.println(x + " ");
        });

    }
}
