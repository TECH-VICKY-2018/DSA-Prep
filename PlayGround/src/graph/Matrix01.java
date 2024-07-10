package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Matrix01 {

    static class RowColPair {
        int row;
        int col;

        public RowColPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int[][] updateMatrix(int[][] mat) {

        int rowSize = mat.length;
        int colSize = mat[0].length;

        int[][] distance = new int[rowSize][colSize];

        for (int[] dis : distance) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }

        Queue<RowColPair> Q = new ArrayDeque<>();

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (mat[row][col] == 0) {
                    distance[row][col] = 0;
                    Q.add(new RowColPair(row, col));
                }
            }
        }

        while (!Q.isEmpty()) {
            RowColPair rowColPair = Q.poll();
            int currRow = rowColPair.row;
            int currCol = rowColPair.col;

            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if (newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize) {
                    if (distance[newRow][newCol] > distance[currRow][currCol] + 1) {
                        //incase the distance to reach the mat(newRow,newCol) is greater than the distance(currRow, currCol) +1 ,
                        // then distance(currRow, currCol) +1 can be the updated distance as it will be shorter.
                        // +1 because we will be adding 1 more step to reach the newRow, newCol.
                        // > and not >= because if it was =, let it have the same value, no need to update
                        Q.add(new RowColPair(newRow, newCol));
                        distance[newRow][newCol] = distance[currRow][currCol] + 1;
                    }
                }
            }
        }
        return distance;
    }
}
