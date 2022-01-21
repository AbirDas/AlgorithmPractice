package Trie;

import java.util.List;

public class ReplaceWords {

	public static void main(String[] args) {
		/*
		Input:- dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
		Output:- "the cat was rat by the bat"
		*/
	}

	class Solution {
	    public String replaceWords(List<String> dictionary, String sentence) {
	        if(dictionary==null || sentence==null || sentence.isEmpty()) return "";
	        TrieNode trie = new TrieNode();
	        
	        for(String dic : dictionary) {
	            TrieNode curr = trie;
	            for(char ch : dic.toCharArray()) {
	                if(curr.child[ch-'a']==null) curr.child[ch-'a'] = new TrieNode();
	                curr = curr.child[ch-'a']; 
	            }
	            curr.word = dic;
	        }
	        
	        StringBuilder ans = new StringBuilder();
	        
	        for(String str : sentence.split("\\s+")){
	            if(ans.length()>0) ans.append(" ");
	            
	            TrieNode curr = trie;
	            for(char ch : str.toCharArray()) {
	                if(curr.child[ch-'a']==null || curr.word!=null) break;
	                curr = curr.child[ch-'a'];
	            }
	            
	            ans.append(curr.word!=null ? curr.word : str);                
	        }
	        return ans.toString();
	    }
	}

	class TrieNode {
	    TrieNode[] child;
	    String word;
	    public TrieNode() {
	        child = new TrieNode[26];
	    }
	}
}
