package dynamicProgramming.FibonacciBasedDP.minCostClimbingStairs;

import java.util.Arrays;

//Memoization: O(n) time and O(n) space
public class MemoizationApproach {
	int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo,-1);
        return Math.min(helper(0, cost), helper(1, cost));
    }

    private int helper(int index, int[] cost) {
        if (index >= cost.length)
            return 0;

        if (memo[index] != -1) {
            return memo[index];
        }
        return memo[index] = cost[index] + Math.min(helper(index + 1, cost), helper(index + 2, cost));
    }
}
