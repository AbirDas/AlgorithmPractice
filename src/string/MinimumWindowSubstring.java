package string;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	
	
    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1<len2) return "";
        String answer = "";
        int matchCharacter = 0;
        int i=-1;
        int j=-1;
        
        Map<Character,Integer> map2 = new HashMap<>();
        for(int k=0; k<len2; k++) {
            char ch = t.charAt(k);
            map2.put(ch,map2.getOrDefault(ch,0) +1);
        }
        
        Map<Character,Integer> map1 = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //collect match
            while(i<len1-1 && matchCharacter<len2) {
                ++i;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)){
                    matchCharacter++;
                }
                f1 = true;
            }
            
            //get possible answer & remove 
            while(j<i && matchCharacter==len2) {
                String current = s.substring(j+1,i+1);
                if(answer.length()<1 || current.length()<answer.length()){
                    answer = current;
                }
                
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }
                
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                    matchCharacter--;
                }
                f2 = true;
            }
            if(f1==false && f2==false){
                break;
            }
        }
        return answer;
    }

}
