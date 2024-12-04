package dynamicProgramming.FibonacciBasedDP.decodeWays;

import java.util.HashMap;

//Memoization(Bottom Up): TC - O(n), SC - O(n)
public class MemoizationApproach {
	private HashMap<Integer, Integer> memo;

    public int numDecodings(String s) {
        memo = new HashMap<>();
        return helper(s, 0);
    }

    private int helper(String s, int index) {
        if (index == s.length())
            return 1;
        if (s.charAt(index) == '0')
            return 0;
        
        if (memo.containsKey(index))
            return memo.get(index);

        // Decode one digit
        int ways = helper(s, index + 1);

        // Decode two digit
        // This extracts a substring from the string s, starting at position index (inclusive) and ending at position index + 2 (exclusive).
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26)
            ways += helper(s, index + 2);
        
        memo.put(index, ways);

        return ways;
    }
}
