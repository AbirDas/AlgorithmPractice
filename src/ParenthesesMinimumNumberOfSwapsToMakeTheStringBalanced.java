
public class ParenthesesMinimumNumberOfSwapsToMakeTheStringBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSwaps("]]][[["));
	}
	
	
    public static int minSwaps(String s) {
        int size = 0;
        final int len = s.length();
        
        for(int i=0; i<len; i++) {
            char ch = s.charAt(i);
            if(ch=='[') {
                size++;
            }else{
                if(size>0) {
                    size--;
                }
            }
        }
        return (size+1)/2;
    }

}
