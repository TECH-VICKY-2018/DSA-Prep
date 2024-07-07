package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BfsImpl {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];
        int startNode = 0;
        vis[startNode] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {

            int currNode = queue.poll();
            res.add(currNode);

            for (int neigh : adj.get(currNode)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    queue.add(neigh);
                }
            }
        }


        return res;

    }
}
