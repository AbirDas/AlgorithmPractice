package parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("((()((s((((()"));
	}
	
    public static List<String> removeInvalidParentheses(String s) {
        int minimumCharToRemove = minNumberToRemove(s);
        Set<String> set = new HashSet<>();
        recursionCheck(s,minimumCharToRemove,set);
        return new ArrayList<String>(set);
    }
    
    public static int minNumberToRemove(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c: s.toCharArray()) {
            
            if(c=='('){
                st.push(c);
            }else if(c==')'){
                if(st.isEmpty()){
                    st.push(c);
                }else if(st.peek()=='('){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }
        return st.size();
    }
    
    public static void recursionCheck(String s, int mar, Set<String> set) {
        
        if(mar==0){
            if(minNumberToRemove(s)==0){
                if(!set.contains(s)){
                    set.add(s);
                }
            }
            return;
        }
        
        int len = s.length();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if((c!='(') && (c!=')')) continue;
            
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            recursionCheck(left+right,mar-1,set);
        }
    } 

}
