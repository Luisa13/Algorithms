package hard.exercises;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * @author luisa
 */
public class MergedKSortedList {

	public static class ListNode {
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

	/**
	 * APPROACH 1 
	 * In this approach we use a priority queue to sort the elements
	 * which makes it O(n) in space while in time is O(n log n). 
	 * There is a good discussion about this here: https://stackoverflow.com/questions/3759112/whats-faster-inserting-into-a-priority-queue-or-sorting-retrospectively/10761286
	 * 
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (ListNode linkedList : lists) {
			while (linkedList != null) {
				pq.add(linkedList.val);
				linkedList = linkedList.next;
			}
		}

		if (pq.size() == 0)
			return null;

		ListNode sortedList = new ListNode(pq.remove());
		while (!pq.isEmpty()) {
			ListNode newNode = new ListNode(pq.remove(), null);
			newNode.next = sortedList;
			sortedList = newNode;
		}

		return sortedList;

	}
}
