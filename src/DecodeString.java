import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[a]2[bc]"));
	}
	
	public String decodeString(String s) {
        int len = s.length();
        Stack<String> sStack = new Stack<String>();
        Stack<Integer> iStack = new Stack<Integer>();
        int index = 0;
        String reserve = "";
        
        while(index < len) {
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    count = (count*10)+(s.charAt(index)-'0');
                    index++;
                }
                iStack.push(count);
            }else if(s.charAt(index) == '[') {
                sStack.push(reserve);
                reserve="";
                index++;
            }else if(s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(sStack.pop());
                int count = iStack.pop();
                for(int i=0; i<count;i++) {
                    temp.append(reserve);
                }
                reserve = temp.toString();
                index++;
            }else {
                reserve += s.charAt(index);
                index++;
            }
        }
        return reserve;
    }

}
