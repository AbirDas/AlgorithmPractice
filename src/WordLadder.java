import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordLadder {
	
	public static void main(String[] args) {
		//System.out.println(ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
		System.out.println(ladderLength("hit","cog", Arrays.asList("hot","dof","dog","fot","log","cog")));
	}
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> word = new HashSet<>(wordList);
        if(!word.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int shortLenght = 1;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> swapSet = new HashSet<>();
            for(String begin : beginSet) {
                List<String> nearWord = getNumber(begin);
                for(String current : nearWord) {
                    if(endSet.contains(current)) return shortLenght + 1;
                    if(word.contains(current)) {
                        swapSet.add(current);
                        word.remove(current);
                    }
                }
            }
            beginSet = swapSet;
            shortLenght++;
        }
        return 0;
    }
    
    public static List<String> getNumber(String str) {
        List<String> result = new ArrayList<>();
        char[] wordChar = str.toCharArray();
        for(int i=0; i<wordChar.length; i++) {
            char curChar = wordChar[i];
            for(char c='a'; c<='z'; c++) {
                if(c == curChar) continue;
                wordChar[i] = c;
                String nearString = String.valueOf(wordChar);
                result.add(nearString);
            }
            wordChar[i] = curChar;
        }
        return result;
    }
}