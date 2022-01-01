package TreeAndLinkedList;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNodesInKGroup rnkg = new ReverseNodesInKGroup();
		rnkg.printLinkedList(rnkg.reverseKGroup(rnkg.formLinkedList(new int[] { 1, 2, 3, 4, 5 }), 3));
	}

	// main reverse logic
	public ListNode reverse(ListNode head, int k) {
		ListNode curr = head;
		ListNode pre = null;

		while (k > 0) {
			ListNode nextNode = curr.next;
			curr.next = pre;
			pre = curr;
			curr = nextNode;
			k--;
		}
		return pre;
	}

	// main logic appending node after reverse
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1 || head == null || head.next == null)
			return head;

		ListNode ptr = head, curr = head;
		ListNode newHead = null, tail = null;

		while (ptr != null) {
			int count = 0;
			ptr = curr;
			while (k > count && ptr != null) {
				ptr = ptr.next;
				count++;
			}

			if (count == k) {
				ListNode reverseNode = reverse(curr, k);
				if (newHead == null) newHead = reverseNode;
				if (tail != null) tail.next = reverseNode;
				tail = curr;
				curr = ptr;
			}
			if (tail != null) tail.next = curr;
		}
		return newHead == null ? head : newHead;
	}

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode formLinkedList(int[] arr) {
		ListNode head = new ListNode();
		ListNode temp = head;
		for (int i = 0; i < arr.length; i++) {
			temp.val = arr[i];
			if (i != arr.length - 1) {
				temp.next = new ListNode();
				temp = temp.next;
			}
		}
		return head;
	}

	public void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
