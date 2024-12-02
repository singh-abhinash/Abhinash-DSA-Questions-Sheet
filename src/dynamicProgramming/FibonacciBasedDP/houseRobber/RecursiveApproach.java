package dynamicProgramming.FibonacciBasedDP.houseRobber;

//Recursion Approach: TC - O(2^n)
public class RecursiveApproach {
	public int rob(int[] nums) {
        return solve(nums, 0);
    }

    private int solve(int[] nums, int i) {
        if (i >= nums.length)
            return 0;
        
        int steal = nums[i] + solve(nums, i+2);
        int skip = solve(nums, i+1);

        return Math.max(steal, skip);
    }
}
