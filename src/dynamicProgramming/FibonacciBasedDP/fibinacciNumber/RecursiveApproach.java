package dynamicProgramming.FibonacciBasedDP.fibinacciNumber;

// TC - O(2^n)
public class RecursiveApproach {
	public int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }
}
