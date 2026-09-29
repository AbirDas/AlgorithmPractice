package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ABC"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null && s.length()==0) return 0;

        int len = s.length();
        int ans=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0, j=0; i<len; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                j = Math.max(map.get(ch), j);
            }

            ans = Math.max(ans, (i+1)-j);
            map.put(ch,i+1);
        }
        return ans;
    }
}
