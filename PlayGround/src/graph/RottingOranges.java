package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottingOranges {

    static class RowColTime {
        int row;
        int col;
        int time;

        public RowColTime(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


    private boolean isSafe(int[][] grid, boolean[][] vis, int newRow, int newCol, int rowSize, int colSize) {
        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize && !vis[newRow][newCol] && grid[newRow][newCol] == 1;
    }

    public int orangesRotting(int[][] grid) {

        int rowSize = grid.length;
        int colSize = grid[0].length;

        boolean[][] vis = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(vis[i], false);
        }

        int freshOrangeCount = 0;

        Queue<RowColTime> Q = new ArrayDeque<>();

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 2) {
                    Q.add(new RowColTime(row, col, 0));
                    vis[row][col] = true;
                }

                if (grid[row][col] == 1) {
                    freshOrangeCount++;
                }
            }
        }

        int maxTime = 0;

        while (!Q.isEmpty()) {
            RowColTime rowColTime = Q.poll();

            int row = rowColTime.row;
            int col = rowColTime.col;
            int time = rowColTime.time;

            maxTime = Math.max(time, maxTime);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isSafe(grid, vis, newRow, newCol, rowSize, colSize)) {
                    Q.add(new RowColTime(newRow, newCol, time + 1));
                    vis[newRow][newCol] = true;
                    freshOrangeCount--;
                }
            }
        }

        if (freshOrangeCount > 0) return -1;

        return maxTime;

    }

}
