package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NumberOfIslands {

    static class RowColIndexPair {
        int row;
        int col;

        public RowColIndexPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


    private boolean isSafe(int newRow, int newCol, int rowSize, int colSize, char[][] grid /*, boolean[][] vis*/) {
        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize && grid[newRow][newCol] == '1' /*&& !vis[newRow][newCol]*/;
    }

    private void bfs(int i, int j, char[][] grid /*, boolean[][] vis*/, int rowSize, int colSize) {


        Queue<RowColIndexPair> Q = new ArrayDeque<>();

        Q.add(new RowColIndexPair(i, j));

        while (!Q.isEmpty()) {
            RowColIndexPair rowColIndexPair = Q.poll();

            for (int[] dir : directions) {
                int newRow = rowColIndexPair.row + dir[0];
                int newCol = rowColIndexPair.col + dir[1];

                if (isSafe(newRow, newCol, rowSize, colSize, grid/*, vis*/)) {
//                    vis[newRow][newCol] = true;
                    grid[newRow][newCol] = 'V';
                    Q.add(new RowColIndexPair(newRow, newCol));
                }
            }
        }

    }


    public int numIslands(char[][] grid) {
        int rowSize = grid.length;
        if (rowSize == 0) return 0;
        int colSize = grid[0].length;

        int islands = 0;

//        boolean[][] vis = new boolean[rowSize][colSize];
//        for (boolean[] visited : vis) {
//            Arrays.fill(visited, false);
//        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (/*!vis[i][j] &&*/ grid[i][j] == '1') {
//                    vis[i][j] = true;
                    grid[i][j] = 'V';
                    islands++;
                    bfs(i, j, grid /*, vis*/, rowSize, colSize);
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        // Test Case 1: Basic test case with one island
        char[][] grid1 = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands (Test Case 1): " + solution.numIslands(grid1)); // Expected output: 2

        // Test Case 2: No islands (all water)
        char[][] grid2 = {
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'}
        };
        System.out.println("Number of islands (Test Case 2): " + solution.numIslands(grid2)); // Expected output: 0

        // Test Case 3: All land (one big island)
        char[][] grid3 = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        System.out.println("Number of islands (Test Case 3): " + solution.numIslands(grid3)); // Expected output: 1

        // Test Case 4: Multiple small islands
        char[][] grid4 = {
                {'1', '0', '0', '1'},
                {'0', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'1', '0', '0', '1'}
        };
        System.out.println("Number of islands (Test Case 4): " + solution.numIslands(grid4)); // Expected output: 6

        // Test Case 5: Large grid with complex island patterns
        char[][] grid5 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '1', '1', '0', '0'}
        };
        System.out.println("Number of islands (Test Case 5): " + solution.numIslands(grid5)); // Expected output: 3
    }


}
