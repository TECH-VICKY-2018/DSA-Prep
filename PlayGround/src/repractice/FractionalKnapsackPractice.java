package repractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsackPractice {

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

        public RatioIndex(double ratio, int index) {
            this.ratio = ratio;
            this.index = index;
        }
    }

    static class RatioIndexListComparator implements Comparator<RatioIndex> {

        @Override
        public int compare(RatioIndex o1, RatioIndex o2) {
            return Double.compare(o2.ratio, o1.ratio);
        }
    }

    double fractionalKnapsack(int w, Item[] arr, int n) {
        // Your code here
        List<RatioIndex> ratioIndexList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int value = arr[i].value;
            int weight = arr[i].weight;
            double ratio = (double) value / weight;
            ratioIndexList.add(new RatioIndex(ratio, i));
        }

        ratioIndexList.sort(new RatioIndexListComparator());

        int i = 0;
        double maxValue = 0.0;
        while (w > 0 && i < n) {
            RatioIndex ratioIndex = ratioIndexList.get(i);
            Item item = arr[ratioIndex.index];

            if (item.weight < w) {
                double value = (double) item.value;
                maxValue += value;
            } else {
                double value = w * ratioIndex.ratio;
                maxValue += value;
            }

            w -= item.weight;
            i++;

        }


        return maxValue;
    }

}
