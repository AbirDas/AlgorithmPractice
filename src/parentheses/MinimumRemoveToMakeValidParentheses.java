package parentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
	}
	
    public static String minRemoveToMakeValid(String s) {
        Set<Integer> charToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
     
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(c=='(') {
                stack.push(i);
            }else if(c==')'){
                if(stack.isEmpty()) {
                    charToRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) charToRemove.add(stack.pop());
        
        StringBuilder str = new StringBuilder();
        for(int i=0; i<len; i++) {
            if(!charToRemove.contains(i)){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

}
