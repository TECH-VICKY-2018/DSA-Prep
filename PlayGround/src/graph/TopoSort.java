package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopoSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        Stack<Integer> stack = new Stack<Integer>();

        boolean[] vis = new boolean[V];

        for (int node = 0; node < V; node++) {
            if (!vis[node]) {
                dfs(node, vis, adj, stack);
            }
        }

        int[] ans = new int[V];

        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.pop();
        }

        return ans;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;
        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                dfs(neigh, vis, adj, stack);
            }
        }
        stack.push(node);
    }


}
