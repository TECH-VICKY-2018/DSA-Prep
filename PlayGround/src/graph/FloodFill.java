package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FloodFill {

    static class RowColIndexPair {
        int row;
        int col;

        public RowColIndexPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rowSize = image.length;
        int colSize = image[0].length;

        int currentColor = image[sr][sc];

        boolean[][] vis = new boolean[rowSize][colSize];

        for (boolean[] v : vis) {
            Arrays.fill(v, false);
        }

        Queue<RowColIndexPair> Q = new ArrayDeque<>();


        Q.add(new RowColIndexPair(sr, sc));
        vis[sr][sc] = true;
        image[sr][sc] = color;

        while (!Q.isEmpty()) {
            RowColIndexPair rowColIndexPair = Q.poll();

            int currRow = rowColIndexPair.row;
            int currCol = rowColIndexPair.col;

            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (isSafe(newRow, newCol, image, vis, currentColor, rowSize, colSize)) {
                    Q.add(new RowColIndexPair(newRow, newCol));
                    vis[newRow][newCol] = true;
                    image[newRow][newCol] = color;
                }
            }

        }

        return image;

    }

    private boolean isSafe(int newRow, int newCol, int[][] image, boolean[][] vis, int currentColor, int rowSize, int colSize) {
        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize && !vis[newRow][newCol] && image[newRow][newCol] == currentColor;
    }


}
