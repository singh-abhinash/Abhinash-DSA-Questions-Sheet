package dynamicProgramming.FibonacciBasedDP.jumpGame;

// Bottom Up Approach(DP): O(n^2) time and O(n) space
public class BottomUpApproach {
	public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true; // Base case: start at index 0
        // dp[0] indicates whether the starting position (index 0) is reachable.
        // Since we always start at the first index, it is trivially reachable, so dp[0] is set to true.

        for (int index = 0; index < n; index++) {
            if (dp[index]) { // If we can reach index i
                int maxJump = Math.min(index + nums[index], n - 1); // Maximum reachable index from i
                for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
                    dp[nextIndex] = true; // Mark as reachable
                }
            }
        }

        // Return whether we can reach the last index
        return dp[n-1];
    }
}
