package dynamicProgramming.FibonacciBasedDP.fibinacciNumber;

// Bottom Up Approach
public class FibonacciNumber {
	public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] fibonacci = new int[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[n];
    }
}
