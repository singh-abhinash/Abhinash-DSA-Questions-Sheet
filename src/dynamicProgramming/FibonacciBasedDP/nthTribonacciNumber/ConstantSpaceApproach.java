package dynamicProgramming.FibonacciBasedDP.nthTribonacciNumber;

//Using constant space: O(n) time and O(1) space
public class ConstantSpaceApproach {
	public int tribonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;

        int zerothTribo = 0;
        int onethTribo = 1;
        int twothTribo = 1; 

        for(int i = 3; i < n+1; i++){
            int currentTribo = zerothTribo + onethTribo + twothTribo;
            zerothTribo = onethTribo;
            onethTribo = twothTribo;
            twothTribo = currentTribo;
        }

        return twothTribo;
    }
}
