package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class IsCyclicUndirected {

    static class NodeParentPair {
        int node;
        int parent;

        public NodeParentPair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        int startNode = 0;

        for (int node = 0; node < V; node++) {
            if (!vis[node]) {
                if (bfsIsCycle(node, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean bfsIsCycle(int Node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[Node] = true;
        Queue<NodeParentPair> Q = new ArrayDeque<>();

        Q.add(new NodeParentPair(Node, -1));

        while (!Q.isEmpty()) {
            NodeParentPair nodeParentPair = Q.poll();
            int currNode = nodeParentPair.node;
            int parent = nodeParentPair.parent;

            for (int neigh : adj.get(currNode)) {
                if (!vis[neigh]) {
                    Q.add(new NodeParentPair(neigh, currNode));
                    vis[neigh] = true;
                } else if (neigh != parent) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int node = 0; node < V; node++) {
            if (!vis[node]) {
                if (dfsIsCycle(node, adj, vis, -1)) return true;
            }
        }
        return false;
    }

    private boolean dfsIsCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {

        vis[node] = true;

        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                if(dfsIsCycle(neigh, adj, vis, node)) return true;
            } else if (neigh!=parent) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 6;

        // Adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(4);
        adj.get(4).add(1);
        adj.get(1).add(5);
        adj.get(5).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        // Create an instance of IsCyclicUndirected
        IsCyclicUndirected isCyclicUndirected = new IsCyclicUndirected();

        // Check for cycle
        boolean result = isCyclicUndirected.isCycleDFS(V, adj);

        // Print the result
        System.out.println(result ? 1 : 0);  // Expected output: 0 (no cycle)
    }
}

