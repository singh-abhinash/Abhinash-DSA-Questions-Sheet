package dynamicProgramming.FibonacciBasedDP.jumpGameII;

//Greedy Approach: O(n) time and O(1) space
public class GreedyApproachConstantSpace {
	public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, maxReach = 0, curReach = 0;
        for (int i = 0; i < n - 1; i++) {
            // if I will put i < n then it will fail for this [0] array
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == curReach) {
                jumps++;
                curReach = maxReach;
                
                if (curReach >= n-1)
                    return jumps;
                //I added below two statements to cover if it will not reach to end of the array then return 0...but Actualy this case is out of scope but it is helpful for followups problem. If you want you can remove for this this problem
                // ex - [1,2,1,0,0]
                if (i >= maxReach) 
                    return 0; // Cannot reach the end
            }
        }
        return jumps;
	}
}
