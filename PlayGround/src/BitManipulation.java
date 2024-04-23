import java.util.Scanner;

public class BitManipulation {

    public static int posOfRightMostSetBit(int n) {
        int value = (n & (n - 1)) ^ n; //This gives us the decimal value of binary which has only the right most set bit
        // we have to return log2(value), because position = 2's exponent
        double twoExp = Math.log10(value) / Math.log10(2); //log2(N) = log10(N)/log10(2)
        return (int) twoExp + 1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(posOfRightMostSetBit(n));




    }
}
