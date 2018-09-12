/**
 * 
 */
package com.playarea.trees;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class BinrySearchTree {

	TreeNode root;

	void insert(int value) {
		if (root == null) {
			root = new TreeNode(1);
			return;
		}
		insertNode(root, value);
	}

	private TreeNode insertNode(TreeNode node, int value) {

		if (node == null)
			return new TreeNode(value);
		if (value < node.getValue())
			node.setLeft(insertNode(node.getLeft(), value));
		else
			node.setRight(insertNode(node.getRight(), value));

		return node;

	}

	void inOrder() {
		inOrderRecursive(root);
	}

	void preOrder() {

		preOrderRecursive(root);
	}

	private void preOrderRecursive(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getValue() + " ");
		preOrderRecursive(root.getLeft());
		preOrderRecursive(root.getRight());

	}

	private void inOrderRecursive(TreeNode root) {
		if (root == null)
			return;
		inOrderRecursive(root.getLeft());
		System.out.print(root.getValue() + " ");
		inOrderRecursive(root.getRight());

	}

	private void postOrderRecursive(TreeNode root) {
		if (root == null)
			return;
		postOrderRecursive(root.getLeft());
		postOrderRecursive(root.getRight());
		System.out.print(root.getValue() + " ");

	}

	void postOrder() {
		postOrderRecursive(root);
	}
}
