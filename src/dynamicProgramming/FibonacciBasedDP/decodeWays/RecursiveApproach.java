package dynamicProgramming.FibonacciBasedDP.decodeWays;

//Recursion: TC - O(2^n), SC - O(n)
public class RecursiveApproach {
	public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int index) {
        if (index == s.length())
            return 1;
        if (s.charAt(index) == '0')
            return 0;
        
        // Decode one digit
        int ways = helper(s, index + 1);

        // Decode two digit
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26)
            ways += helper(s, index + 2);
        
        return ways;
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Fibonacci Connection:
 * -> Basic Idea of Fibonacci: In Fibonacci, the n-th number is calculated by summing the (n−1)-th and (n−2)-th numbers:
 * 	   		-> F(n)=F(n−1)+F(n−2)
 * 
 * Decode Ways:
 * -> To determine the number of ways to decode up to the i-th position in the string:
 * 		-> Option 1: Treat the current character s[i−1] as a single digit (if it’s valid, i.e. 1 ≤ s[i−1] ≤ 9).
 * 		-> Option 2: Combine s[i−2] and s[i−1] as a two-digit number (if it’s valid, i.e. 10 ≤ s[i−2]s[i−1] ≤ 26).
 * 	This creates the recurrence relation:
 * 			-> ways(i)=ways(i−1)+ways(i−2)
 * 
 * Why This Matches Fibonacci:
 * -> You’re calculating how many ways you can "build up" to the current position.
 * -> Each step depends only on the previous two steps.
 * -> This overlap of subproblems is the hallmark of the Fibonacci pattern.
 * 
 */

