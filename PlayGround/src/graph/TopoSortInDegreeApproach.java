package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class TopoSortInDegreeApproach {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] inDegree = new int[V];

        Arrays.fill(inDegree, 0);

        for (int i = 0; i < V; i++) {
            for (int neigh : adj.get(i)) {
                inDegree[neigh]++;
            }
        }

        Queue<Integer> Q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                Q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!Q.isEmpty()) {
            int currNode = Q.poll();
            res.add(currNode);

            for (int neigh : adj.get(currNode)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    Q.add(neigh);
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();

    }

}
