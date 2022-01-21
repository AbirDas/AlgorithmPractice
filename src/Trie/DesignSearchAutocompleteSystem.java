package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		/*
		 Input:-
		["AutocompleteSystem", "input", "input", "input", "input"]
		[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
		
		Output:-
		[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]

		Explanation:-
		AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
		obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
		obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
		obj.input("a"); // return []. There are no sentences that have prefix "i a".
		obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
		*/
	}
	
	class AutocompleteSystem {
	    
	    class TrieNode {
	        Map<Character, TrieNode> trie;
	        Map<String, Integer> count;
	        public TrieNode() {
	            trie = new HashMap<>();
	            count = new HashMap<>();
	        }
	    }
	    
	    class Pair {
	        String val;
	        int cnt;
	        public Pair(String s,int i) {
	            val = s;
	            cnt=i;
	        }
	    }
	    
	    TrieNode root;
	    StringBuilder prefix;
	    
	    public AutocompleteSystem(String[] sentences, int[] times) {
	        root=new TrieNode();
	        prefix = new StringBuilder();
	        
	        for(int i=0; i<sentences.length; i++) {
	            add(sentences[i], times[i]);
	        }
	    }
	    
	    private void add(String sentences, int times) {
	        TrieNode curr = root;
	        
	        for(char ch : sentences.toCharArray()) {
	            TrieNode next = curr.trie.get(ch);
	            if(next==null){
	                next = new TrieNode();
	                curr.trie.put(ch,next);
	            }
	            curr = next;
	            curr.count.put(sentences,curr.count.getOrDefault(sentences,0)+times);
	        }
	    }
	    
	    public List<String> input(char c) {
	        if(c=='#') {
	            add(prefix.toString(),1);
	            prefix = new StringBuilder();
	            return new ArrayList<String>();
	        }
	        
	        prefix.append(c);
	        TrieNode curr = root;
	        
	        for(char ch : prefix.toString().toCharArray()) {
	            TrieNode next = curr.trie.get(ch);
	            if(next==null) {
	                return new ArrayList<String>();
	            }
	            curr = next;
	        }
	        
	        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cnt==b.cnt ? a.val.compareTo(b.val) : b.cnt-a.cnt);
	        for(Map.Entry<String,Integer> e : curr.count.entrySet()) {
	            pq.offer(new Pair(e.getKey(),e.getValue()));
	        }
	        
	        List<String> ans = new ArrayList<>();
	        for(int i=0; i<3 && !pq.isEmpty(); i++) {
	            ans.add(pq.poll().val);
	        }
	        return ans;
	    }
	}

	/**
	 * Your AutocompleteSystem object will be instantiated and called as such:
	 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
	 * List<String> param_1 = obj.input(c);
	 */

}
