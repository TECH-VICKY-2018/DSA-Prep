package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DfsImpl {

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {

        vis[node] = true;
        res.add(node);

        for (int neigh : adj.get(node)) {
            if (!vis[node]) {
                dfs(neigh, vis, adj, res);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V + 1];
        vis[0] = true;
        Arrays.fill(vis, false);
        int startNode = 0;
        ArrayList<Integer> res = new ArrayList<>();

        dfs(startNode, vis, adj, res);

        return res;
        // Code here
    }
}
