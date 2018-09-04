/**
 * 
 */
package com.playarea;

import java.util.Random;

/**
 * @author chandrashekharv
 *
 */
public class MergeSortedLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode[] listNodes = new ListNode[100];
		for (int i = 0; i < 100; i++) {
			listNodes[i] = createLinkedListOfListNodes();
		}
		// merge(new ListNode[] { l1, l2, l3 });
		// ListNode currentNode = merge(listNodes);

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(0);
		ListNode currentNode = merge(new ListNode[] { node1, node2 });

		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}

	private static ListNode merge(ListNode[] lists) {

		if (lists == null || lists.length == 0)
			return null;

		ListNode list0 = lists[0];
		if (lists.length == 1)
			return list0;
		if (lists.length == 2) {
			return mergeTwoLists(lists[0], lists[1]);
		}

		int amount = lists.length;
		int interval = 1;

		while (interval < amount) {
			for (int i = 0; i < amount - interval; i += interval * 2) {
				lists[i] = mergeTwoListsNonRecursive(lists[i], lists[i + interval]);
			}
			interval *= 2;
		}
		return lists[0];
	}

	private static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {

		if (listNode1 == null)
			return listNode2;
		if (listNode2 == null)
			return listNode1;

		if (listNode1.value < listNode2.value) {
			listNode1.next = mergeTwoLists(listNode1.next, listNode2);
			return listNode1;
		} else {
			listNode2.next = mergeTwoLists(listNode2.next, listNode1);
			return listNode2;
		}

	}

	private static ListNode mergeTwoListsNonRecursive(ListNode listNode1, ListNode listNode2) {
		if (listNode1 == null)
			return listNode2;
		if (listNode2 == null)
			return listNode1;

		ListNode head = null;
		if (listNode1.value < listNode2.value) {
			head = listNode1;
		} else {
			head = listNode2;
			listNode2 = listNode1;
			listNode1 = head;
		}
		while (listNode1.next != null) {
			if (listNode1.next.value > listNode2.value) {
				ListNode temp = listNode1.next;
				listNode1.next = listNode2;
				listNode2 = temp;
			}
			listNode1 = listNode1.next;
		}
		listNode1.next = listNode2;

		return head;
	}

	private static ListNode createLinkedListOfListNodes() {
		Random random = new Random();
		ListNode listNode = new ListNode(random.ints(1, 100).findAny().getAsInt());
		ListNode node2 = new ListNode(random.ints(101, 1000).findAny().getAsInt());
		listNode.next = node2;
		ListNode node3 = new ListNode(random.ints(1001, 100001).findAny().getAsInt());
		node2.next = node3;
		return listNode;
	}

	public static class ListNode {
		private int value;
		private ListNode next;

		public ListNode(int value) {
			super();
			this.value = value;
		}

	}

}
