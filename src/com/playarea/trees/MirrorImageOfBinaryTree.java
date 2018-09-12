/**
 * 
 */
package com.playarea.trees;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class MirrorImageOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Tree tree = IdenticalStructureTrees.treeSupplier.get();
		BFS bfs = new BFS();
		bfs.apply(tree);
		mirrorIt(tree);
		bfs.apply(tree); 
	}

	private static void mirrorIt(Tree tree) {
		mirrorNodes(tree.getRoot());

	}

	private static void mirrorNodes(TreeNode node) {
		if (node == null)
			return;
		TreeNode temp = node.getRight();
		node.setRight(node.getLeft());
		node.setLeft(temp);

		mirrorNodes(node.getLeft());
		mirrorNodes(node.getRight());
	}

}
