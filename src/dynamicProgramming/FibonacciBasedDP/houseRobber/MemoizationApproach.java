package dynamicProgramming.FibonacciBasedDP.houseRobber;

import java.util.Arrays;

//Memoization(Top Dowm Approach): TC - O(n), SC - O(n)
public class MemoizationApproach {
	private int[] memo;

    public int rob(int[] nums) {
        this.memo = new int[101];
        Arrays.fill(this.memo, -1);
        
        return solve(nums, 0);
    }

    private int solve(int[] nums, int i) {
        if (i >= nums.length)
            return 0;
        
        if (this.memo[i] != -1)
            return this.memo[i];

        int steal = nums[i] + solve(nums, i+2);
        int skip = solve(nums, i+1);

        return this.memo[i] = Math.max(steal, skip);
    }
}
