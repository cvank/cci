/**
 * 
 */
package com.playarea.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.playarea.trees.Tree.TreeNode;

/**
 * @author chandrashekharv
 *
 */
public class BFS {

	public void apply(Tree tree) {

		if (tree == null)
			return;

		bfs(tree.getRoot());
	}

	private void bfs(TreeNode node) {

		List<TreeNode> waitingQueue = new LinkedList<>();
		waitingQueue.add(node);
		while (!waitingQueue.isEmpty()) {
			node  = waitingQueue.remove(0);
			System.out.println(node.getValue() + " ");
			if (null != node.getLeft())
				waitingQueue.add(node.getLeft());
			if (null != node.getRight())
				waitingQueue.add(node.getRight());
		}

	}
}
