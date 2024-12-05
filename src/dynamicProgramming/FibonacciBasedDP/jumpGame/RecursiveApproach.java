package dynamicProgramming.FibonacciBasedDP.jumpGame;

public class RecursiveApproach {
	public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int index) {
        // Base case: If we've reached the last index
        if (index >= nums.length - 1)
            return true;

        // Get the maximum distance we can jump from the current index
        int maxJump = Math.min(index + nums[index], nums.length - 1);

        // Try all possible jumps from the current position
        for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
            if (helper(nums, nextIndex)) {
                return true;
            }
        }

        // If none of the jumps lead to the last index
        return false;
    }
}
