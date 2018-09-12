/**
 * 
 */
package com.playarea.trees;

import java.util.Stack;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class PrintTreeInSpiral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Tree tree = IdenticalStructureTrees.treeSupplier2.get();

		printInSpiral(tree);

	}

	private static void printInSpiral(Tree tree) {
		StringBuilder builder = new StringBuilder();
		spiral(tree.getRoot(), builder);
		
		System.out.println(builder.toString()); 

	}

	private static void spiral(TreeNode root, StringBuilder builder) {

		builder.append(root.getValue());

		Stack<TreeNode> nodes = new Stack<>();
		nodes.push(root);

		Stack<TreeNode> subNodes = new Stack<>();
		boolean evenLevel = true;
		while (!nodes.empty()) {
			TreeNode child = nodes.pop();
			if (evenLevel) {
				if (null != child.getLeft()) {
					builder.append(child.getLeft().getValue());
					subNodes.push(child.getLeft());
				}
				if (null != child.getRight()) {
					builder.append(child.getRight().getValue());
					subNodes.push(child.getRight());
				}
			} else {
				if (null != child.getRight()) {
					builder.append(child.getRight().getValue());
					subNodes.push(child.getRight());
				}
				if (null != child.getLeft()) {
					builder.append(child.getLeft().getValue());
					subNodes.push(child.getLeft());
				}
			}
			if (nodes.isEmpty()) {
				nodes.addAll(subNodes);
				subNodes = new Stack<>();
				evenLevel = !evenLevel;
			}
		}

	}

}
