package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0, top = 0;
        int right = m - 1, bottom = n - 1;


        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 1}, {8, 9, 4, 1}, {7, 6, 5, 1}};

        SpiralArray obj = new SpiralArray();

        System.out.println(obj.spiralOrder(arr).toString());


    }

}
