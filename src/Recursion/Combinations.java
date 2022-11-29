package Recursion;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		/*
		 * Input: n = 4, k = 2 
		 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
		 * Explanation: There are 4 choose 2 = 6 total combinations. Note that
		 * combinations are unordered, i.e., [1,2] and [2,1] are considered to be the
		 * same combination.
		 */
		
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));
	}
	
	List<List<Integer>> answer = new LinkedList<List<Integer>>();
	int n,k;
	
	public List<List<Integer>> combine(int n, int k) {
		this.n=n;
		this.k=k;
		backtracing(1,new LinkedList<Integer>());
		return answer;
	}
	
	private void backtracing(int first, LinkedList<Integer> curr) {
		if(curr.size()==k) {
			answer.add(new LinkedList(curr));
		}
		
		for(int i=first; i<=n; i++) {
			curr.add(i);
			backtracing(i+1,curr);
			curr.removeLast();
		}
		
	}

}
