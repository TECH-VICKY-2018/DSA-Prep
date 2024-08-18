package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestDistanceBinaryMaze {

    class XYDist {
        int x;
        int y;
        int dist;

        public XYDist(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }


    private static boolean isSafe(int newX, int newY, int[][] disArray, int currDist, int n, int m, int[][] grid) {
        return newX >= 0 && newY >= 0 && newX < n && newY < m && grid[newX][newY] == 1 && disArray[newX][newY] > currDist + 1;
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        // Your code here
        int n = grid.length;
        int m = grid[0].length;

        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        Queue<XYDist> Q = new ArrayDeque<>();
        int[][] disArray = new int[n][m];

        for (int[] dis : disArray) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }

        disArray[source[0]][source[1]] = 0;
        int distance = 0;

        Q.add(new XYDist(source[0], source[1], 0));

        while (!Q.isEmpty()) {
            XYDist xyDist = Q.poll();
            int xIndex = xyDist.x;
            int yIndex = xyDist.y;
            int currDist = xyDist.dist;

            for (int[] dir : directions) {
                int newX = xIndex + dir[0];
                int newY = yIndex + dir[1];
                if (isSafe(newX, newY, disArray, currDist, n, m, grid)) {
                    disArray[newX][newY] = currDist + 1;
                    if (newX == destination[0] && newY == destination[1]) {
                        return currDist + 1;
                    }
                    Q.add(new XYDist(newX, newY, currDist + 1));
                }
            }
        }
        return -1; // Return -1 if no path exists between the source and destination points.
    }
}
