package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionBasics {

    public int sumOfNNumbersFunctional(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNNumbersFunctional(n - 1);
    }

    public void sumOfNNumbersParameterized(int n, int sum) {
        if (n < 1) {
            System.out.println("Sum of numbers (parameterized) = " + sum);
            return;
        }
        sumOfNNumbersParameterized(n - 1, sum + n);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverseArrayWithRecursion(int[] arr, int i, int j) {

        if (i >= j) {
            System.out.println("Reversed array : " + Arrays.toString(arr));
            return;
        }
        swap(arr, i, j);
        reverseArrayWithRecursion(arr, i + 1, j - 1);
    }

    static boolean isPalRec(String str, int s, int e) {
        // If there is only one character
        if (s == e)
            return true;

        // If first and last
        // characters do not match
        if ((str.charAt(s)) != (str.charAt(e)))
            return false;

        // If there are more than
        // two characters, check if
        // middle substring is also
        // palindrome or not.
        if (s < e + 1)
            return isPalRec(str, s + 1, e - 1);

        return true;
    }

    static boolean isPalindrome(String str) {
        int n = str.length();

        // An empty string is
        // considered as palindrome
        if (n == 0)
            return true;

        return isPalRec(str, 0, n - 1);
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;

        RecursionBasics rb = new RecursionBasics();
        System.out.println("Sum of " + n + " numbers (Functional)  = " + rb.sumOfNNumbersFunctional(n));
        rb.sumOfNNumbersParameterized(n, 0);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        rb.reverseArrayWithRecursion(arr, 0, arr.length - 1);

        String str = "malayalam";


        if (isPalindrome(str))
            System.out.println(str + " is a palindrome");
        else
            System.out.println(str + " is not a palindrome");


        System.out.println(n + "th fibonacci number is" + fibonacci(n));
    }

}
