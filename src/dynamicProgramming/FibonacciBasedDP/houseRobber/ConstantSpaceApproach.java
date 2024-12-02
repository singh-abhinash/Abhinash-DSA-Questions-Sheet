package dynamicProgramming.FibonacciBasedDP.houseRobber;

//Optimized Approach: O(n) time and O(1) space
public class ConstantSpaceApproach {
	public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) // No houses to rob
            return 0; 
        if (n == 1) // Only one house to rob
            return nums[0]; 

        int previousMaxPlusOne = 0; // Maximum money robbed up to two houses ago(i-2)
        int previousMax = nums[0]; // Maximum money robbed up to the last house(i-1)

        for (int i = 2; i <= n; i++) {
            int currentMax = Math.max(nums[i - 1] + previousMaxPlusOne, previousMax);
            previousMaxPlusOne = previousMax; // Shift previous max to current
            previousMax = currentMax; // Update current max
        }
        return previousMax;
    }
}
