package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvinces {

    private static void dfs(int currNode, boolean[] vis, List<ArrayList<Integer>> adj) {
        vis[currNode] = true;

        for (int neigh : adj.get(currNode)) {
            if (!vis[neigh]) dfs(neigh, vis, adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;
        boolean[] vis = new boolean[V + 1];
        List<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        Arrays.fill(vis, false);

        for (int node = 0; node < V; node++) {
            if (!vis[node]) {
                count++;
                dfs(node, vis, adj);
            }
        }

        return count;

    }


}
