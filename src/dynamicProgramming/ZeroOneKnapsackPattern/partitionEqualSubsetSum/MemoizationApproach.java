package dynamicProgramming.ZeroOneKnapsackPattern.partitionEqualSubsetSum;

import java.util.Arrays;

public class MemoizationApproach {
	private Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        // If total sum is odd, partition is not possible
        if (sum % 2 != 0) 
            return false;

        int target = sum / 2;

        // Initialize memo table with null (since Boolean can be true, false, or null)
        memo = new Boolean[n][target + 1];

        return helper(nums, n - 1, target);
    }

    private boolean helper(int[] nums, int n, int sum) {
        // Base cases
        if (sum == 0) 
            return true;
        if (n < 0 || sum < 0) 
            return false;

        // If already computed, return the stored result
        if (memo[n][sum] != null) 
            return memo[n][sum];

        // Choice to include or exclude the current item
        boolean include = helper(nums, n - 1, sum - nums[n]);
        boolean exclude = helper(nums, n - 1, sum);

        // Store the result in the memo table
        memo[n][sum] = include || exclude;
        return memo[n][sum];
    }
}
