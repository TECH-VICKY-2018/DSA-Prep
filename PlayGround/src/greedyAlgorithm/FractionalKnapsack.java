package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    static class RatioIndex {
        double ratio;
        int index;

        public RatioIndex(double r, int i) {
            this.ratio = r;
            this.index = i;
        }
    }

    static class RatioReverseComparator implements Comparator<RatioIndex> {
        @Override
        public int compare(RatioIndex o1, RatioIndex o2) {
            return Double.compare(o2.ratio, o1.ratio);
        }
    }

    double fractionalKnapsack(int w, Item arr[], int n) {
        // List to store value to weight ratios with their indices
        List<RatioIndex> ratioIndexPairs = new ArrayList<>();

        // Calculate ratios and store them
        for (int i = 0; i < n; i++) {
            Item item = arr[i];
            // Corrected the ratio calculation to simple value to weight
            ratioIndexPairs.add(new RatioIndex((double) item.value / item.weight, i));
        }

        // Sort ratios in descending order
        ratioIndexPairs.sort(new RatioReverseComparator());

        double totalValue = 0.0; // To keep track of the total value of items in knapsack
        int currentWeight = 0;   // To keep track of current weight in knapsack

        // Iterate through items in descending order of their value to weight ratio
        for (RatioIndex ratioIndexPair : ratioIndexPairs) {
            Item item = arr[ratioIndexPair.index];

            // If the entire item can be added
            if (currentWeight + item.weight <= w) {
                totalValue += item.value;
                currentWeight += item.weight;
            } else {
                // If only part of the item can be added
                int availableWeight = w - currentWeight;
                totalValue += (ratioIndexPair.ratio * availableWeight); // Corrected fractional value addition
                break; // Knapsack is full
            }
        }
        return totalValue; // Return the maximum value
    }
}
