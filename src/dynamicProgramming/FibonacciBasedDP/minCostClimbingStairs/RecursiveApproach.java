package dynamicProgramming.FibonacciBasedDP.minCostClimbingStairs;

//Recursion: O(2^n) time and O(n) space
public class RecursiveApproach {
	public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(0, cost), helper(1, cost));
    }

    private int helper(int index, int[] cost) {
        if (index >= cost.length)
            return 0;
        
        return cost[index] + Math.min(helper(index + 1, cost), helper(index + 2, cost));
    }
}
