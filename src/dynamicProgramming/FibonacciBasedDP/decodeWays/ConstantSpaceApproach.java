package dynamicProgramming.FibonacciBasedDP.decodeWays;

//Constant Space: O(n) time and O(1) space
public class ConstantSpaceApproach {
	public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prevMinusTwothIndex = 1; // Base case for dp[i-2]
        int prevMinusOnethIndex = s.charAt(0) != '0' ? 1 : 0; // Base case for dp[i-1]

        for (int i = 2; i <= s.length(); i++) {
            int current = 0;
            // Decode one digit
            if (s.charAt(i - 1) != '0') {
                current += prevMinusOnethIndex;
            }
            // Decode two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prevMinusTwothIndex;
            }

            prevMinusTwothIndex = prevMinusOnethIndex;
            prevMinusOnethIndex = current;
        }

        return prevMinusOnethIndex;
    }
}
