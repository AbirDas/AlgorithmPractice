package BitManipulation;

public class Base7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToBase7(100));
	}
	
	 public static String convertToBase7(int num) {
	        if(num==0) return "0";
	        /*if(num<0) return "-" + convertToBase7(-num);
	        if(num<7) return Integer.toString(num);
	        return convertToBase7(num/7) + Integer.toString(num%7);*/
	        boolean isNeg = false;
	        if(num < 0){
	            isNeg = true;
	        }
	        
	        num = Math.abs(num);
	        StringBuffer sb = new StringBuffer();
	        
	        while(num != 0) {
	            sb.append(num%7);
	            num = num/7;
	        }
	        
	        if(isNeg) sb.append("-");
	        return sb.reverse().toString();
	    }

}
