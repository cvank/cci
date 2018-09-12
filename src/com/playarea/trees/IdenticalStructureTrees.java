/**
 * 
 */
package com.playarea.trees;

import java.util.function.Supplier;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class IdenticalStructureTrees {

	static Supplier<Tree> treeSupplier = () -> createTree();
	static Supplier<Tree> treeSupplier1 = () -> createTree1();
	static Supplier<Tree> treeSupplier2 = () -> createTree2();

	private static Tree createTree() {
		Tree tree = new Tree();
		TreeNode node = new TreeNode(1);
		tree.setRoot(node);

		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		node.setLeft(left);
		node.setRight(right);

		left.setLeft(new TreeNode(4));
		left.setRight(new TreeNode(5));
		return tree;
	}

	private static Tree createTree2() {
		Tree tree = new Tree();
		TreeNode node = new TreeNode(1);
		tree.setRoot(node);

		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		node.setLeft(left);
		node.setRight(right);

		left.setLeft(new TreeNode(4));
		left.setRight(new TreeNode(5));
		left.getLeft().setLeft(new TreeNode(8));
		left.getLeft().setRight(new TreeNode(9));
		left.getRight().setLeft(new TreeNode(10));
		left.getRight().setRight(new TreeNode(11));
		
		right.setLeft(new TreeNode(6));
		right.setRight(new TreeNode(7));
		right.getLeft().setLeft(new TreeNode(12));
		right.getLeft().setRight(new TreeNode(13));
		right.getRight().setLeft(new TreeNode(14));
		right.getRight().setRight(new TreeNode(15));
		
		
		return tree;
	}

	private static Tree createTree1() {
		Tree tree = new Tree();
		TreeNode node = new TreeNode(1);
		tree.setRoot(node);

		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		node.setLeft(left);
		node.setRight(right);

		left.setLeft(new TreeNode(4));
		left.setRight(new TreeNode(5));
		right.setLeft(new TreeNode(6));
		right.setRight(new TreeNode(7));
		return tree;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree1 = treeSupplier.get();
		Tree tree2 = treeSupplier1.get();

		System.out.println(isIdenticalInStructure(tree1, tree2));

	}

	private static boolean isIdenticalInStructure(Tree tree1, Tree tree2) {
		if (tree1 == null && tree2 == null)
			return true;

		return isIdenticalNodes(tree1.getRoot(), tree2.getRoot());

	}

	private static boolean isIdenticalNodes(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;

		else if (node1 != null && node2 != null)
			return isIdenticalNodes(node1.getLeft(), node2.getLeft())
					&& isIdenticalNodes(node1.getRight(), node2.getRight());

		return false;
	}

}
