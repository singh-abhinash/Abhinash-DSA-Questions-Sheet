package dynamicProgramming.FibonacciBasedDP.houseRobber;

//Bottom Up Approach: TC - O(n), SC - O(n)
public class BottomUpDpApproach {
	public int rob(int[] nums) {
        int[] dp = new int[101];
        int n = nums.length;
        //dp[i] means maximum profit till ith house
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            int steal = nums[i-1] + dp[i-2];
            int skip = dp[i-1];

            dp[i] = Math.max(steal, skip);
        }
        return dp[n];
    }
}
