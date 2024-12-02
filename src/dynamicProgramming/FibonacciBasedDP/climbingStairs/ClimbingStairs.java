package dynamicProgramming.FibonacciBasedDP.climbingStairs;

public class ClimbingStairs {
	public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] distinctWaysToClimb = new int[46];
        distinctWaysToClimb[1] = 1;
        distinctWaysToClimb[2] = 2;
        for (int i = 3; i <= 45; i++) {
            distinctWaysToClimb[i] = distinctWaysToClimb[i-1] + distinctWaysToClimb[i-2];
        }
        return distinctWaysToClimb[n];
    }
}
