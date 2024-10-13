package arrays;

public class Main {

    public static void main(String[] args) {

        MaximumProductSubarray obj = new MaximumProductSubarray();

        int[] nums = {2, 3, -2, 4, -1, 0, -3, 5, 6};

        long result = obj.maxProduct(nums);

        System.out.println("maxProduct : " + result);


    }

}
