package basics;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicExecutions {

    public void pattern2(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public void pattern3(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void pattern4(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

    }

    public void pattern5(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern6(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private void pattern7(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void pattern8(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public void pattern9(int n) {
        pattern7(n);
        pattern8(n);
    }

    public void pattern10(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {

            /* stars would be equal to the
            row no. uptill first half */
            int stars = i;

            // for the second half of rotated triangle.
            if (i > n) stars = 2 * n - i;

            // for printing the stars in each row.
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            /* As soon as the stars for each iteration are printed,
            we move to the next row and give a line break */
            System.out.println();
        }

    }

    public static void main(String[] args) {
        BasicExecutions br = new BasicExecutions();
        br.pattern10(4);
    }
}
