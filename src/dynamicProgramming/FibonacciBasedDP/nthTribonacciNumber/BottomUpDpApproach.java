package dynamicProgramming.FibonacciBasedDP.nthTribonacciNumber;

// Bottom Down: TC - O(n), SC - O(n)
public class BottomUpDpApproach {
	public int tribonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int[] tribo = new int[n+1];
        tribo[0] = 0;
        tribo[1] = 1;
        tribo[2] = 1;
        for(int i = 3; i < n+1; i++){
            tribo[i] = tribo[i-1] + tribo[i-2] + tribo[i-3];
        }
        return tribo[n];
    }
}
