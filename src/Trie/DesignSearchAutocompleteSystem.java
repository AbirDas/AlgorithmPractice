package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignSearchAutocompleteSystem {

	public static void main(String[] args) {

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
