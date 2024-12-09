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

    private boolean helper(int[] nums, int index, int sum) {
        // Base cases
        if (sum == 0) 
            return true;
        if (index < 0 || sum < 0) 
            return false;

        // If already computed, return the stored result
        if (memo[index][sum] != null) 
            return memo[index][sum];

        // Choice to include or exclude the current item
        boolean include = helper(nums, index - 1, sum - nums[index]);
        boolean exclude = helper(nums, index - 1, sum);

        // Store the result in the memo table
        memo[index][sum] = include || exclude;
        return memo[index][sum];
    }
}
