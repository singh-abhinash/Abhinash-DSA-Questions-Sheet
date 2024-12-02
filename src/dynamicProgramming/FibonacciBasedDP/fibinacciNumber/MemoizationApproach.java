package dynamicProgramming.FibonacciBasedDP.fibinacciNumber;

import java.util.Arrays;

//Top Down Approach
public class MemoizationApproach {
	public int fib(int n) {
		// Initialize memoization array with default values of -1
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return fibHelper(n, memo);
	}

	private int fibHelper(int n, int[] memo) {
		// Base cases
		if (n == 0) 
			return 0;
		if (n == 1) 
			return 1;

		// Check if already computed
		if (memo[n] != -1) 
			return memo[n];

		// Compute and store in memo
		return memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
    
	}
}

