/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv You are given two non-empty linked lists representing
 *         two non-negative integers. The digits are stored in reverse order and
 *         each of their nodes contain a single digit. Add the two numbers and
 *         return it as a linked list.
 * 
 *         You may assume the two numbers do not contain any leading zero,
 *         except the number 0 itself.
 * 
 *         Example
 * 
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation:
 *         342 + 465 = 807.
 *
 */
public class AddTwoNumbersLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);

		ListNode currentNode = result;
		while (currentNode != null) {
			System.out.print(currentNode.val);
			currentNode = currentNode.next;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode root1 = reverse(l1);
		ListNode root2 = reverse(l2);
		ListNode currentNodeFromRoot1 = root1;
		ListNode currentNodeFromRoot2 = root2;
		ListNode result = null;
		int carry = 0;
		int addValue = 0;
		ListNode previousNode = null;
		while (currentNodeFromRoot1 != null && currentNodeFromRoot2 != null) {

			int val = currentNodeFromRoot1.val + currentNodeFromRoot2.val + carry;
			carry = val / 10;
			addValue = val % 10;
			if (result == null) {
				ListNode newValNode = new ListNode(addValue);
				previousNode = newValNode;
				result = previousNode;
			} else {
				ListNode newValNode = new ListNode(addValue);
				previousNode.next = newValNode;
				previousNode = newValNode;
			}
			currentNodeFromRoot1 = currentNodeFromRoot1.next;
			currentNodeFromRoot2 = currentNodeFromRoot2.next;
		}

		return result;
	}

	private static ListNode reverse(ListNode l1) {
		ListNode currentNode = l1;
		ListNode nextNode = null;
		ListNode previousNode = null;
		while (currentNode != null) {

			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;

		}
		return previousNode;
	}

}
