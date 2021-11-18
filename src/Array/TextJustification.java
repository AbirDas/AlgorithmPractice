package Array;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new LinkedList<String>();
        if(words==null || words.length==0) return answer;
        int len = words.length;
        
        
        int i=0;
        while(i<len) {
            int wc = words[i].length();
            int j=i+1;
            int reqSpace = 0;
            
            while(j<len && wc+reqSpace+words[j].length()+1<=maxWidth){
                wc += words[j].length();
                reqSpace++;
                j++;
            }
            
            int vac = maxWidth-wc;
            
            int atleast = (reqSpace==0) ? 0 : vac/reqSpace;
            int extra = (reqSpace==0) ? 0 : vac%reqSpace;
            
            if(j==len){
                atleast=1;
                extra=0;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int k=i; k<j; k++) {
                sb.append(words[k]);
                if(k==j-1) break;
                for(int f=0; f<atleast; f++) sb.append(" ");
                if(extra>0) {
                    sb.append(" ");
                    extra--;
                }
            }
            
            while(sb.length() < maxWidth) sb.append(" ");
            answer.add(sb.toString());
            i=j;
        }
        return answer;
    }
	
}
