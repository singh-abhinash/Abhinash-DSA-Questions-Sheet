package dynamicProgramming.FibonacciBasedDP.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

// Time complexity - O(n^2), Space complexity - O(n^2)
public class Solution {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        
        if (numRows == 0)
            return pascalTriangle;
        
        // Base case: first row is always [1]
        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = pascalTriangle.get(i-1);
            List<Integer> currentRow = new ArrayList<>();

            currentRow.add(1); // First element of the row is always 1
            
            // Compute the middle elements
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            
            currentRow.add(1); // Last element of the row is always 1
            
            // Adding currentRow to the Pascal triangle
            pascalTriangle.add(currentRow);
        }

        return pascalTriangle;
    }
}
