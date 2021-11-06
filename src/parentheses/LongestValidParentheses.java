package parentheses;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//using stack
    public int stackLongestValidParentheses(String s) {
        if(s==null || s.length()<2) return 0;
        Stack<Integer> st = new Stack<Integer>();
        int len = s.length();
        int maxValue = 0;
        st.push(-1);
        
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            
            if(c=='(') {
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()) {
                    st.push(i);
                }else{
                    int l = i-st.peek();
                    maxValue = Math.max(maxValue,l);
                }
            }
        }
        return maxValue;
    }
    
    //using int parameter
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2) return 0;
        int len = s.length();
        int open=0,close=0,max=0;
        
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(c=='('){
                open++;
            }else{
                close++;
            }
            
            if(open==close){
                max = Math.max(max,open*2);
            }else if(close>open){
                open=close=0;
            }
        }
        
        open=close=0;
        for(int i=len-1; i>=0; i--) {
            char c = s.charAt(i);
            if(c=='('){
                open++;
            }else{
                close++;
            }
            
            if(open==close){
                max = Math.max(max,open*2);
            }else if(open>close){
                open=close=0;
            }
        }
        
        return max;
    }

}
