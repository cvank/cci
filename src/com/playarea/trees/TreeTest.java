/**
 * 
 */
package com.playarea.trees;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class TreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		binaryTreeTest();
		binarySearchTreeTest();

	}

	private static void binarySearchTreeTest() {
		BinrySearchTree tree = new BinrySearchTree();
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(100);
		tree.insert(8);
		tree.insert(6);
		tree.insert(4);
		tree.insert(2);

		tree.preOrder();
		tree.inOrder();
		tree.postOrder();

	}

	private static void binaryTreeTest() {
		Tree tree = new Tree();
		TreeNode node = new TreeNode(1);
		tree.setRoot(node);

		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		node.setLeft(left);
		node.setRight(right);

		left.setLeft(new TreeNode(4));
		left.setRight(new TreeNode(5));

		tree.preOrder(node);
		tree.inOrder(node);
		tree.postOrder(node);
	}

}
