package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("O(NNN)");
        for (int i = 0; i < n; i++) {
            printPascalTriangleRow(i+1);
            System.out.println(" ");
        }
        System.out.println("O(NN)");
        List<List<Integer>> pascalTriangle = pascalTriangle(n);
        for (List<Integer> pascalRow : pascalTriangle) {
            System.out.println(pascalRow.toString());
        }


    }

    private static void printPascalTriangleRow(int n) {

        for (int C = 1; C <= n; C++) {

            System.out.print(getNCR(n - 1, C - 1) + " ");

        }

    }

    private static int getNCR(int R, int C) {
        int res = 1;
        for (int i = 0; i < C; i++) {
            res = res * (R - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static List<List<Integer>> pascalTriangle(int numRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> pascalRow = getPascalRow(i + 1);
            pascalTriangle.add(pascalRow);
        }

        return pascalTriangle;

    }

    private static List<Integer> getPascalRow(int Row) {

        List<Integer> pascalRow = new ArrayList<>();

        long ans = 1;
        pascalRow.add(1);

        for (int Col = 1; Col < Row; Col++) {
            ans *= (Row - Col);
            ans /= Col;
            pascalRow.add((int) ans);
        }
        return pascalRow;

    }


}
