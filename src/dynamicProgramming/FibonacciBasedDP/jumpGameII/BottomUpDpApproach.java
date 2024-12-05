package dynamicProgramming.FibonacciBasedDP.jumpGameII;

import java.util.Arrays;

//Bottom Up DP: O(n^2) time and O(n) space
public class BottomUpDpApproach {
	public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] represents the minimum jumps needed to reach index i
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize with a large value
        dp[0] = 0; // Base case: 0 jumps needed to reach the starting index

        for (int index = 0; index < n; index++) {
            int maxJump = Math.min(index + nums[index], n - 1); // Maximum reachable index from i
            for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
                dp[nextIndex] = Math.min(dp[nextIndex], dp[index] + 1); // Update the minimum jumps needed
            }
        }

        return dp[n - 1]; // Minimum jumps needed to reach the last index
    }
}
