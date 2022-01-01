package TreeAndLinkedList;

public class IMP_RotateList {

	public static void main(String[] args) {

	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;

		// find size
		int size = 1;
		ListNode tail = head;
		while (tail != null && tail.next != null) {
			tail = tail.next;
			size++;
		}

		k = k % size;

		// connect head to tail make circular linklist
		tail.next = head;

		int counter = size - k;
		while (counter > 0) {
			tail = tail.next;
			counter--;
		}

		ListNode newHead = tail.next;
		tail.next = null;

		return newHead;
	}

	/**
	 * Definition for singly-linked list.
	 */
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
}
