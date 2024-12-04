package dynamicProgramming.FibonacciBasedDP.decodeWays;

//Bottom Up Approach: O(n) time and O(n) space
public class BottomUpDpApproach {
	public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        
        int n = s.length();
        int[] dp = new int[n+1];
        // dp[i] represents the number of ways to decode the substring s[0..i-1], i.e., the first i characters of the string s.
        dp[0] = 1; // for empty string
        dp[1] = s.charAt(0) != '0' ? 1 : 0; 

        for (int i = 2; i < n+1; i++) {
            // Decode one string
            if (s.charAt(i-1) != '0')
                dp[i] += dp[i-1];

            // Decode two string
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * The base case dp[0] = 1 is set to 1 because there is exactly one way to decode an empty string: by doing nothing.
 * 
 * Why is this needed?
 * In the Decode Ways problem:
 * -> dp[i] depends on dp[i-1] (decoding using the last one character) and dp[i-2] (decoding using the last two characters).
 * -> If i = 1, and you are decoding the first character of the string, the logic for decoding s[i-1] adds dp[i-1] to dp[i]. 
 * For this to work properly, dp[0] must represent a valid state (which is 1 because there's exactly one way to decode an 
 * empty prefix).
 * 
 * Think of it as a starting point:
 * -> If the string s = "12", you can decode it like:
 * 		1) Decode "1" first → The remaining part "2" has dp[1] ways.
 * 		2) Decode "12" directly → The remaining part (empty string) has dp[0] ways.
 * -> Without setting dp[0] = 1, the logic for adding dp[i-2] when decoding two characters would fail, as it wouldn't know 
 * how to handle the case when the prefix is empty.
 * 
 * Analogy:
 * Imagine you're climbing stairs (similar to the Fibonacci pattern):
 * -> If you're at the ground (before the first step), there's exactly one way to "stay" there: do nothing. Similarly, 
 * there's one way to decode an empty string.
 */
