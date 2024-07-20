package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDAGWeighted {

    public static class NodeAndWeight {
        int node;
        int weight;

        public NodeAndWeight(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private void topoDfsHelper(int node, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<NodeAndWeight>> adj) {
        vis[node] = true;
        for (NodeAndWeight neighNodeAndWeight : adj.get(node)) {
            int neigh = neighNodeAndWeight.node;
            if (!vis[neigh]) {
                topoDfsHelper(neigh, vis, stack, adj);
            }
        }
        stack.push(node);
    }

    // edge = [[0,1,2],[0,2,1]]
    public int[] shortestPath(int N, int M, int[][] edges) {
        int[] disArray = new int[N];
        ArrayList<ArrayList<NodeAndWeight>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Corrected edge processing loop
        for (int i = 0; i < M; i++) {  // Changed N to M to correctly iterate over edges
            adj.get(edges[i][0]).add(new NodeAndWeight(edges[i][1], edges[i][2]));
        }

        boolean[] vis = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int node = 0; node < N; node++) {
            if (!vis[node]) {
                topoDfsHelper(node, vis, stack, adj);
            }
        }

        Arrays.fill(disArray, Integer.MAX_VALUE);
        disArray[0] = 0;

        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (disArray[currNode] != Integer.MAX_VALUE) {
                for (NodeAndWeight nodeAndWeight : adj.get(currNode)) {
                    int newNode = nodeAndWeight.node;
                    int newWeight = nodeAndWeight.weight;
                    int newDist = disArray[currNode] + newWeight; // Fixed calculation of newDist
                    if (newDist < disArray[newNode]) {
                        disArray[newNode] = newDist;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (disArray[i] == Integer.MAX_VALUE) {
                disArray[i] = -1;
            }
        }
        return disArray;
    }
}
