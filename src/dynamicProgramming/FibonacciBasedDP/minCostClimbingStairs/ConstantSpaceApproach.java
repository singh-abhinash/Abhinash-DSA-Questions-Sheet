package dynamicProgramming.FibonacciBasedDP.minCostClimbingStairs;

//Constant Space: O(n) time and O(1) space
public class ConstantSpaceApproach {
	public int minCostClimbingStairs(int[] cost) {
        int prevMinusTwothIndexElement = cost[0];
        int prevMinusOnethIndexElement = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int currentIndexElement = cost[i] + Math.min(prevMinusOnethIndexElement, prevMinusTwothIndexElement);
            prevMinusTwothIndexElement = prevMinusOnethIndexElement;
            prevMinusOnethIndexElement = currentIndexElement;
        }

        return Math.min(prevMinusOnethIndexElement, prevMinusTwothIndexElement);
    }
}
