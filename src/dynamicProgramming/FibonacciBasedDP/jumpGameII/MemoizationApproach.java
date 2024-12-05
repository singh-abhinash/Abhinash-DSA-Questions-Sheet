package dynamicProgramming.FibonacciBasedDP.jumpGameII;

import java.util.Arrays;

//Memoization(Top Down): O(n^2) time and O(n) space
public class MemoizationApproach {
	int[] memo;
    
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int index) {
        // Base case: If we've reached the last index or beyond
        if (index >= nums.length - 1)
            return 0;

        // If we can't move further from this index, return a large value
        // We dont need this case because in question it is mentioned that we will always reach to n-1th
        // index.
        if (nums[index] == 0)
            return Integer.MAX_VALUE;

        if (memo[index] != -1)
            return memo[index];

        int minJumps = Integer.MAX_VALUE;
        int maxJump = Math.min(index + nums[index], nums.length - 1);

        // Try all possible jumps from the current position
        for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
            int result = helper(nums, nextIndex);
            if (result != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + result);
            }
        }

        return memo[index] = minJumps;
    }
}
