
public class GreatestCommonDivisorOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcdOfStrings("ABABAB","ABAB"));
	}

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        if(str1.length()<str2.length())  return gcdOfStrings(str2,str1);
        
        String reminder = str1.substring(str2.length());
        if(reminder.isEmpty()) return str2;
        return gcdOfStrings(str2,reminder);
    }
	
}
