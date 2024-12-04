package dynamicProgramming.FibonacciBasedDP.generateParehnthesis;

import java.util.ArrayList;
import java.util.List;

//Recursive Approach - O(2^n) time and O(n) space
public class RecursiveApproach {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, n, n, "", n);
        return res;
    }

    public void recurse(List<String> res, int openBrac, int closeBrac, String s, int n) {
        if (openBrac == 0 && closeBrac == 0) {
            res.add(s);
            return;
        }
        
        if (openBrac > 0) {
            recurse(res, openBrac - 1, closeBrac, s + "(", n);
        }
        
        if (closeBrac > openBrac) {
            recurse(res, openBrac, closeBrac - 1, s + ")", n);
        }
    }
}
