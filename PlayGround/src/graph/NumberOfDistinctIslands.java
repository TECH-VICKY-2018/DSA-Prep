package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberOfDistinctIslands {

    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static class UniqueRowCol {
        int row;
        int col;

        public UniqueRowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UniqueRowCol that = (UniqueRowCol) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }


    private boolean isSafe(int newRow, int newCol, boolean[][] vis, int[][] grid, int rowSize, int colSize) {

        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize && !vis[newRow][newCol] && grid[newRow][newCol] == 1;
    }

    private void dfs(int currRow, int currCol, int[][] grid, boolean[][] vis, ArrayList<UniqueRowCol> list, int baseRow, int baseCol) {
        vis[currRow][currCol] = true;

        list.add(new UniqueRowCol(currRow - baseRow, currCol - baseCol));

        for (int[] dir : directions) {
            int newRow = currRow + dir[0];
            int newCol = currCol + dir[1];

            if (isSafe(newRow, newCol, vis, grid, grid.length, grid[0].length)) {
                vis[newRow][newCol] = true;
                dfs(newRow, newCol, grid, vis, list, baseRow, baseCol);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int rowSize = grid.length;
        int colSize = grid[0].length;

        boolean[][] vis = new boolean[rowSize][colSize];

        Set<ArrayList<UniqueRowCol>> uniqueIslandSet = new HashSet<>();

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (!vis[row][col] && grid[row][col] == 1) {
                    ArrayList<UniqueRowCol> list = new ArrayList<>();
                    dfs(row, col, grid, vis, list, row, col);
                    uniqueIslandSet.add(list);
                }
            }
        }
        return uniqueIslandSet.size();
    }


}
