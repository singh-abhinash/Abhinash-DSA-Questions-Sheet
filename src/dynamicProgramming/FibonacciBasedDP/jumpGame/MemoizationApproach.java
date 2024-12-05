package dynamicProgramming.FibonacciBasedDP.jumpGame;

import java.util.Arrays;

//Memoization(Top Down Approach): O(n^2) time and O(n) space
public class MemoizationApproach {
	private int[] memo;

    public boolean canJump(int[] nums) {
        memo = new int[nums.length]; // -1: not processed, 0: false, 1: true
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int index) {
        // Base case: If we've reached the last index
        if (index >= nums.length - 1)
            return true;

        if (memo[index] != -1)
            return memo[index] == 1;

        // Get the maximum distance we can jump from the current index
        int maxJump = Math.min(index + nums[index], nums.length - 1);

        // Try all possible jumps from the current position
        for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
            if (helper(nums, nextIndex)) {
                memo[index] = 1; // Mark as reachable
                return true;
            }
        }

        memo[index] = 0; // Mark as not reachable
        // If none of the jumps lead to the last index
        return false;
    }
}
