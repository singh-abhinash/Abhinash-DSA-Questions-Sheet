package dynamicProgramming.FibonacciBasedDP.jumpGameII;

//Recursion: O(2^n) time and O(n) stack space
public class RecursiveApproach {
	public int jump(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int[] nums, int index) {
        // Base case: If we've reached the last index or beyond
        if (index >= nums.length - 1)
            return 0;

        // If we can't move further from this index, return a large value
        // We dont need this case because in question it is mentioned that we will always reach to n-1th
        // index.
        if (nums[index] == 0)
            return Integer.MAX_VALUE;

        int minJumps = Integer.MAX_VALUE;
        int maxJump = Math.min(index + nums[index], nums.length - 1);

        // Try all possible jumps from the current position
        for (int nextIndex = index + 1; nextIndex <= maxJump; nextIndex++) {
            int result = helper(nums, nextIndex);
            if (result != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + result);
            }
        }

        return minJumps;
    }
}
