package graph.minSpanningTree;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class WeightNodePair {
        int weight;
        int node;

        public WeightNodePair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] vis = new boolean[V];

        PriorityQueue<WeightNodePair> PQ = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        int sum = 0;

        PQ.add(new WeightNodePair(0, 0));

        while (!PQ.isEmpty()) {
            WeightNodePair weightNodePair = PQ.poll();

            int currWeight = weightNodePair.weight;
            int currNode = weightNodePair.node;

            if (!vis[currNode]) {
                sum += currWeight; //add to the mst if needed
                vis[currNode] = true;

                for (int[] neigh : adj.get(currNode)) {
                    int newWeight = neigh[1];
                    int newNode = neigh[0];

                    if (!vis[newNode]) {
                        PQ.add(new WeightNodePair(newWeight,newNode));
                    }
                }
            }
        }
        return sum;
    }
}
