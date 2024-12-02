package dynamicProgramming.FibonacciBasedDP.climbingStairs;

import java.util.Arrays;

// Top Down Approach
public class MemoizationApproach {
	public int climbStairs(int n) {
        // Memoization array, initialized to -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Check memoized results
        if (memo[n] != -1) return memo[n];

        // Compute and store the result
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }
}
