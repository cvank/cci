/**
 * 
 */
package com.playarea.trees;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class IdenticalTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree1 = IdenticalStructureTrees.treeSupplier.get();
		Tree tree2 = IdenticalStructureTrees.treeSupplier1.get();

		System.out.println(areIdentical(tree1, tree2));
	}

	private static boolean areIdentical(Tree tree1, Tree tree2) {
		if (tree1 == null && tree2 == null)
			return true;

		return areIdenticalNodes(tree1.getRoot(), tree2.getRoot());
	}

	private static boolean areIdenticalNodes(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 != null && node1.getValue() == node2.getValue())
			return areIdenticalNodes(node1.getLeft(), node2.getLeft())
					&& areIdenticalNodes(node1.getRight(), node2.getRight());

		return false;
	}

}
