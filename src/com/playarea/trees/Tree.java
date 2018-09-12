/**
 * 
 */
package com.playarea.trees;

/**
 * @author chandrashekharv
 *
 */
public class Tree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// root->left->right
	void preOrder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// left->right->root
	void postOrder(TreeNode node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	// left->root->right
	void inOrder(TreeNode node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	public static class TreeNode {
		private int value;

		private TreeNode left;

		private TreeNode right;

		public TreeNode(int value) {
			super();
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TreeNode other = (TreeNode) obj;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			if (value != other.value)
				return false;
			return true;
		}

	}
}
