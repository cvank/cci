package com.playarea;

import java.util.LinkedList;
import java.util.List;

import com.playarea.MergeSortedLinkedLists.ListNode;

public class MergeSortedLinkedLists2 {

	public static void main(String[] args) {
		inbuiltListMerge();

		Node node = new Node(1);
		node.next = new Node(3);
		node.next.next = new Node(5);

		MyLinkedList linkedList = new MyLinkedList();
		linkedList.root = node;
		
		

		Node node2 = new Node(2);
		node2.next = new Node(4);
		node2.next.next = new Node(6);
		MyLinkedList linkedList2 = new MyLinkedList();
		linkedList2.root = node2;

		mergeMyLinkedList(linkedList, linkedList2);

	}

	private static void mergeMyLinkedList(MyLinkedList linkedList, MyLinkedList linkedList2) {
		Node head = mergeNonRecursion(linkedList.root, linkedList2.root);
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

	private static Node mergeNonRecursion(Node root1, Node root2) {

		Node head = null;

		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;

		if (root1.value < root2.value) {
			head = root1;
		} else {
			head = root2;
			root2 = root1;
			root1 = head;
		}
		while (root1.next != null) {
			if (root1.next.value > root2.value) {
				Node temp = root1.next;
				root1.next = root2;
				root2 = temp;
			}
			root1 = root1.next;
		}
		root1.next = root2;

		return head;

	}

	private static Node mergeRecursion(Node root1, Node root2) {

		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;

		if (root1.value < root2.value) {
			root1.next = mergeRecursion(root1.next, root2);
			return root1;
		} else {
			root2.next = mergeRecursion(root2.next, root1);
			return root2;
		}

	}

	public static class MyLinkedList {
		private Node root;

	}

	private static void inbuiltListMerge() {
		List<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new LinkedList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		
		int minLength = list1.size() < list2.size() ? list1.size() : list2.size();

		List<Integer> resultList = new LinkedList<>();
		int i = 0, j = 0;
		for (; i < minLength && j < minLength;) {
			if (list1.get(i) > list2.get(j)) {
				resultList.add(list2.get(j++));
			} else if (list1.get(i) < list2.get(j)) {
				resultList.add(list1.get(i++));
			} else {
				resultList.add(list1.get(i++));
				resultList.add(list2.get(j++));
			}
		}
		while (i < list1.size()) {
			resultList.add(list1.get(i++));
		}
		while (j < list2.size()) {
			resultList.add(list2.get(j++));
		}

		resultList.stream().forEach(System.out::println);
	}

	public static class Node {
		private int value;
		private Node next;

		public Node(int value) {
			super();
			this.value = value;
		}

	}
}
