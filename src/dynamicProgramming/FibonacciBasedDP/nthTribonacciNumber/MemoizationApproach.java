package dynamicProgramming.FibonacciBasedDP.nthTribonacciNumber;

import java.util.Arrays;

//Memoization: TC - O(n), SC - O(n)
public class MemoizationApproach {
	private int[] tribo;
    public int tribonacci(int n) {
        tribo = new int[n+1];
        Arrays.fill(tribo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        
        if (tribo[n] != -1)
            return tribo[n];

        return tribo[n] = helper(n-1) + helper(n-2) + helper(n-3);
    }
}
