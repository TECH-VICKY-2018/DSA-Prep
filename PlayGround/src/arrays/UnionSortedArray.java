package arrays;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UnionSortedArray {

    private int nextDistinct(int[] nums, int currIndex, int size) {

        while (currIndex < size - 1 && nums[currIndex] == nums[currIndex + 1]) {
            currIndex++;
        }

        return currIndex + 1;

    }

    public int[] unionArray(int[] arr1, int[] arr2) {
        // add your code here
        ArrayList<Integer> unionResult = new ArrayList<>();
        int i = 0, n = arr1.length;
        int j = 0, m = arr2.length;

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

        int[] unionArray = new int[unionResult.size()];

        for (int x = 0; x < unionResult.size(); x++) {
            unionArray[x] = unionResult.get(x);
        }


        return unionArray;
    }

    public static void main(String[] args) {
        UnionSortedArray obj = new UnionSortedArray();

        int[] arr1 = {-8, -3, -3, -2, 0, 1, 2, 2, 6};
        int[] arr2 = {-9, -8, -3, -2, 0, 1, 2, 6};

        int[] res = obj.unionArray(arr1, arr2);

        System.out.println(Arrays.toString(res));

        Arrays.stream(arr1).forEach((int x) -> {
            System.out.println(x + " ");
        });

    }
}
