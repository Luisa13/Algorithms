package recursion.exercises;

import java.util.ArrayList;
import java.util.List;


/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Example: 
 * 		Input: n = 3
 * 		Output: [ "((()))" , "(()())" , "(())()" , "()(())" , "()()()" ]
 * 
 * This exercise is actually an introduction to backtracking and gives a pretty understandable 
 * overview of the type of problem.
 * 
 * @author luisa
 * 
 * */
public class ParenthesisGenerator {

	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis("", 0, 0, res , n);
        return res;
    }
    
    private void generateParenthesis(String localSol, int open, int close, List<String>listParenthesis, int n){
        //System.out.println(localSol);
        if(localSol.length() == 2*n){
            listParenthesis.add(localSol);
            //return listParenthesis;
        }
        else{
            if(open == close){
                System.out.println("open: " + open);
                localSol +="(";
                generateParenthesis(localSol, open+1, close, listParenthesis, n);
            }
            else if(close < open){
                if(open < n)
                    generateParenthesis(localSol + "(", open+1, close, listParenthesis, n);
                
                localSol += ")";
                generateParenthesis(localSol, open, close+1, listParenthesis, n);
            }
        }
        //return listParenthesis;
    }
}
