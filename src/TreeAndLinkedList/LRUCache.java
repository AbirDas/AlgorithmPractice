package TreeAndLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Node head = new Node();
	Node tail = new Node();
	Map<Integer, Node> nodeMap = null;
	int nodeCapacity = 0;

	public LRUCache(int capacity) {
		nodeMap = new HashMap<>(capacity);
		nodeCapacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		int ans = -1;
		Node node = nodeMap.get(key);
		if (node != null) {
			ans = node.val;
			remove(node);
			add(node);
		}
		return ans;
	}

	public void put(int key, int value) {
		if (nodeMap.containsKey(key)) {
			Node node = nodeMap.get(key);
			remove(node);
			node.val = value;
			add(node);
		} else {
			if (nodeMap.size() == nodeCapacity) {
				nodeMap.remove(tail.prev.key);
				remove(tail.prev);
			}
			Node new_node = new Node();
			new_node.key = key;
			new_node.val = value;
			nodeMap.put(key, new_node);
			add(new_node);
		}
	}

	public void add(Node node) {
		Node headNode = head.next;
		head.next = node;
		node.prev = head;
		node.next = headNode;
		headNode.prev = node;
	}

	public void remove(Node node) {
		Node remPrev = node.prev;
		Node remNext = node.next;
		remPrev.next = node.next;
		remNext.prev = node.prev;
	}

	class Node {
		int key;
		int val;
		Node prev;
		Node next;
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 *  LRUCache obj =new LRUCache(capacity); 
	 *  int param_1 = obj.get(key); 
	 *  obj.put(key,value);
	 */

}
