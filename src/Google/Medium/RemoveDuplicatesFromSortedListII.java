package Google.Medium;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode temp = new ListNode();
		temp.next = head;
		ListNode node = temp;
		ListNode ittr = head;

		while (ittr != null) {
			if (ittr.next != null && ittr.val == ittr.next.val) {
				while (ittr.next != null && ittr.val == ittr.next.val) {
					ittr = ittr.next;
				}
				temp.next = ittr.next;

			} else {
				temp = temp.next;
			}

			ittr = ittr.next;
		}
		return node.next;
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
