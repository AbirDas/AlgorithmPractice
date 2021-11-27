package TreeAndLinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public static void main(String[] args) {

	}
	
	
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	    public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length == 0) return null;
	        
	        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
	            public int compare(ListNode l1, ListNode l2) {
	                return l1.val-l2.val;
	            }
	        });
	        ListNode dummy = new ListNode(0);
	        ListNode temp = dummy;
	        
	        for(ListNode node : lists) {
	            if(node!=null) queue.offer(node);
	        }
	        
	        while(!queue.isEmpty()) {
	            temp.next = queue.poll();
	            temp = temp.next;
	            
	            if(temp.next!=null) queue.offer(temp.next);
	        }
	        return dummy.next;
	    }


}
