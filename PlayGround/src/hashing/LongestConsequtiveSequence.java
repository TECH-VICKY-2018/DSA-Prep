package hashing;

public class LongestConsequtiveSequence {

    public int longestConsecutiveBrute(int[] nums) {
        int n = nums.length;

        int longest = 1;

        for (int i = 0; i < n; i++) {
            int max = 1;
            int x = nums[i];

            while (nextElementFound(nums, x + 1)) {
                max++;
                x += 1;
            }

            longest = Math.max(max, longest);

        }
        return longest;
    }

    private boolean nextElementFound(int[] nums, int curr) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                return true;
            }
        }
        return false;
    }

}
