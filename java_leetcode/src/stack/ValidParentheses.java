package stack;

//2022-03-15
//https://leetcode.com/problems/valid-parentheses/
import java.util.Stack;

//Runtime: 2 ms, faster than 81.32% of Java online submissions for Valid Parentheses.
//Memory Usage: 40.3 MB, less than 69.12% of Java online submissions for Valid Parentheses.
public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> parentheses = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(parentheses.empty()) {
                parentheses.push(pair(s.charAt(i)));
            } else if(s.charAt(i) == parentheses.peek()) {
                parentheses.pop();
            } else {
                parentheses.push(pair(s.charAt(i)));
            }
            if(s.charAt(i) == 'r') return false;
        }
        return parentheses.empty();
    }
    public char pair(char c){
        if(c == '('){
            return ')';
        } else if(c == '{'){
            return '}';
        } else if(c == '['){
            return ']';
        } else {
            return 'r';
        }
    }
}