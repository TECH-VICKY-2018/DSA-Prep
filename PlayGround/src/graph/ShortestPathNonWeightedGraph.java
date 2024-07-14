package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathNonWeightedGraph {

    static class NodeDist {
        int node;
        int dist;

        public NodeDist(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<NodeDist> Q = new ArrayDeque<>();

        int[] disArr = new int[n];

        Arrays.fill(disArr, Integer.MAX_VALUE);

        Q.add(new NodeDist(src, 0));
        disArr[src] = 0;

        int[] ans = new int[n];

        while (!Q.isEmpty()) {
            NodeDist nodeDist = Q.poll();
            int node = nodeDist.node;
            int dis = nodeDist.dist;

            for (int neigh : adjList.get(node)) {
                int newDist = dis + 1;
                if (newDist < disArr[neigh]) {
                    disArr[neigh] = newDist;
                    Q.add(new NodeDist(neigh, disArr[neigh]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (disArr[i] >= Integer.MAX_VALUE) {
                ans[i] = -1;
            } else {
                ans[i] = disArr[i];
            }
        }

        return ans;
    }
}
