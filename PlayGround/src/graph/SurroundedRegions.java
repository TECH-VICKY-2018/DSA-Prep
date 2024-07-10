package graph;

import java.util.Arrays;

public class SurroundedRegions {

    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private boolean isSafe(int newRow, int newCol, int rowSize, int colSize, char[][] grid, boolean[][] vis) {
        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize && grid[newRow][newCol] == 'O' && !vis[newRow][newCol];
    }

    private void dfs(int currRow, int currCol, boolean[][] vis, char[][] board, int rowSize, int colSize) {
        vis[currRow][currCol] = true;

        for (int[] dir : directions) {
            int newRow = currRow + dir[0];
            int newCol = currCol + dir[1];

            if (isSafe(newRow, newCol, rowSize, colSize, board, vis)) {
                dfs(newRow, newCol, vis, board, rowSize, colSize);
            }
        }
    }


    public void solve(char[][] board) {

        int rowSize = board.length;
        int colSize = board[0].length;

        boolean[][] vis = new boolean[rowSize][colSize];

        for (boolean[] v : vis) {
            Arrays.fill(v, false);
        }

        for (int col = 0; col < colSize; col++) {
            if (board[0][col] == 'O' && !vis[0][col]) {
                dfs(0, col, vis, board, rowSize, colSize);
            }

            if (board[rowSize - 1][col] == 'O' && !vis[rowSize - 1][col]) {
                dfs(rowSize - 1, col, vis, board, rowSize, colSize);
            }
        }

        for (int row = 0; row < rowSize; row++) {
            if (board[row][0] == 'O' && !vis[row][0]) {
                dfs(row, 0, vis, board, rowSize, colSize);
            }

            if (board[row][colSize - 1] == 'O' && !vis[row][colSize - 1]) {
                dfs(row, colSize - 1, vis, board, rowSize, colSize);
            }
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (!vis[row][col] && board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O'}, {'O', 'X', 'O'}, {'O', 'O', 'O'}};

        SurroundedRegions surroundedRegions = new SurroundedRegions();

        surroundedRegions.solve(board);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }


}
