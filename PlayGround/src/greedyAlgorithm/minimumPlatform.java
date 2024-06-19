package greedyAlgorithm;

import java.util.Arrays;

public class minimumPlatform {

    static int findPlatform(int arr[], int dep[], int n) {
        int platNeeded = 1, maxPlatform = 1;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else {
                platNeeded--;
                j++;
            }

            maxPlatform = Math.max(maxPlatform, platNeeded);
        }
        return maxPlatform;
    }
}
