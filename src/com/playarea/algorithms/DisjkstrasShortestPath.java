/**
 * 
 */
package com.playarea.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.playarea.graph.DirectedWeightedGraph;
import com.playarea.algorithms.DisjkstrasShortestPath.MinBinaryHeap.Node;
import com.playarea.graph.DirectedWeightedGraph.Edge;
import com.playarea.graph.DirectedWeightedGraph.City;

/**
 * @author chandrashekharv
 * 
 *         Algorithm - Background Disjkstra's algorithm is an algorithm for
 *         finding shortest path between two nodes in a given Graph. There are
 *         many variants for Dijkstra's algorithm. One of the popular variants
 *         is to find shortest path between all nodes from the identified source
 *         node in a given graph.
 * 
 *         Example:
 * 
 *         Considering the nodes as cities connected and edges among them
 *         represent distances, Dijkstra's algorithm can be found from one city
 *         to all other cities. Also being used in Network Routing Protocols.
 * 
 *         Algorithm - Runtime Dijkstra's algorithm runs in time O(V^2) where v
 *         represents the number of vertices. This can be improved by using
 *         implementation based on Minimum Priority Queue implemented by
 *         Fibonacci heap for achieving O(E+ V log V) runtime, where E represent
 *         the number of edges.
 * 
 * 
 *         Algorithm - Steps
 * 
 *         1. Mark all nodes UNVISITED. And, create a set for all UNVISITED
 *         nodes.
 * 
 *         2.Set distance for initial node as 0 and INFINITY for remaining
 *         nodes.
 * 
 *         3. For the current node, consider all the unvisited neighbor nodes
 *         and calculate the tentative distance from the current node. Compare
 *         the newly calculated distance with currently assigned value and keep
 *         the minimum value For example, let A is the current node, and B is
 *         it's unvisited neighbor. Now, if A is marked with distance 6 and B
 *         has length 2 then distance to B through A is 8. If B is currently
 *         marked with distance more than 8 then change the value to 8 else keep
 *         the currently marked value as it is.
 * 
 *         4. When we are done with all unvisited neighbors for the current
 *         node, mark the current node as visited and remove from the unvisited
 *         set.
 * 
 *         5. if the destination node is marked as visited OR if the smallest
 *         tentative distance between unvisited set is infinity then stop.
 * 
 *         6. Else, selected the neighbor unvisited node with minimum tentative
 *         distance and mark it as current node.Repeat from Step 3.
 */
public class DisjkstrasShortestPath {

	/**
	 * Returns a map with each node and respective distance from the source node.
	 * 
	 * @param graph
	 * @param source
	 * @return
	 */
	public Map<City, Integer> apply(DirectedWeightedGraph graph, City source) {

		/*
		 * Technical approach
		 * 
		 * 1. For the given graph create a MIN HEAP 2. Take the source node from min
		 * heap and add it to distance map with distance as value which is 0 for source
		 * node. 3. And also add source node to another map, called parent map, with
		 * parent as value which is null in this case for source node. 4. Consider all
		 * neighbors of current node, which is source node now, and repeat the above
		 * process. 5. Do the same until heap is empty.
		 * 
		 */

		Map<City, Integer> distanceMap = new HashMap<>();
		Map<City, City> parentMap = new HashMap<>();

		// Create min heap for all the given nodes of the graph.
		MinBinaryHeap<City> binaryHeap = createMinBinaryHeapFromGraph(graph);

		binaryHeap.decrease(source, 0);
		distanceMap.put(source, 0);
		parentMap.put(source, null);
		while (!binaryHeap.isEmpty()) {
			Node node = binaryHeap.extractMinNode();
			City current = (City) node.key;
			List<Edge> neighbors = getNeighbors(graph, current);
			distanceMap.put(current, node.weight);
			for (Edge edge : neighbors) {

				City city = edge.getDestination();

				if (!binaryHeap.contains(city))
					continue;

				int newDistance = distanceMap.get(current) + edge.getWeight();

				if (binaryHeap.getWeight(city) > newDistance) {
					binaryHeap.decrease(city, newDistance);
					parentMap.put(city, current);
				}
			}

		}
		return distanceMap;

	}

	private List<Edge> getNeighbors(DirectedWeightedGraph graph, City sourceNode) {
		return graph.getAdjacentListMap().get(sourceNode);
	}

	private MinBinaryHeap<City> createMinBinaryHeapFromGraph(DirectedWeightedGraph graph) {

		MinBinaryHeap<City> binaryHeap = new MinBinaryHeap<>();
		graph.getCities().forEach(city -> binaryHeap.add(city, Integer.MAX_VALUE, city.getName()));
		return binaryHeap;
	}

	/**
	 * Min heap data structure with Map support for easy look ups.
	 * 
	 * @author chandrashekharv
	 *
	 */
	public static class MinBinaryHeap<T> {

		public class Node {
			private String name;
			private int weight;
			private T key;

			public T getKey() {
				return key;
			}

			public void setKey(T key) {
				this.key = key;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getWeight() {
				return weight;
			}

			public void setWeight(int weight) {
				this.weight = weight;
			}

			public Node(String name) {
				super();
				this.name = name;
			}

			public Node(String name, int weight, T key) {
				super();
				this.name = name;
				this.weight = weight;
				this.key = key;
			}

			public Node(String name, int weight) {
				super();
				this.name = name;
				this.weight = weight;
			}

		}

		List<Node> nodes;
		Map<T, Integer> nodeIndexMap = new HashMap<>();

		public void add(T key, int weight, String name) {
			Node node = new Node(name, weight, key);
			nodes.add(node);
			int currentIndex = nodes.size() - 1 >= 0 ? nodes.size() - 1 : 0;
			int parentIndex = (currentIndex - 1) / 2;
			nodeIndexMap.put(key, currentIndex);
			while (parentIndex >= 0) {
				Node parentNode = nodes.get(parentIndex);
				Node currentNode = nodes.get(currentIndex);
				if (parentNode.getWeight() > currentNode.getWeight()) {
					swap(parentNode, currentNode);
					updateNodeIndexMap(parentNode.key, currentNode.key, parentIndex, currentIndex);
					currentIndex = parentIndex;
					parentIndex = (parentIndex - 1) / 2;
				} else
					break;

			}
		}

		private void updateNodeIndexMap(T key1, T key2, int parentIndex, int currentIndex) {
			nodeIndexMap.put(key1, parentIndex);
			nodeIndexMap.put(key2, currentIndex);
		}

		public boolean isEmpty() {
			return this.nodes.isEmpty();
		}

		public T extractMin() {

			Node node = extractMinNode();
			rearrangeMinHeap();
			return node.key;

		}

		public int getWeight(T key) {
			int nodeIndex = nodeIndexMap.get(key);

			if (nodeIndex >= 0) {
				return nodes.get(nodeIndex).weight;
			}

			return Integer.MIN_VALUE;
		}

		private void rearrangeMinHeap() {
			Node lastNode = nodes.get(nodes.size() - 1);
			Node rootNode = nodes.get(0);
			nodeIndexMap.remove(rootNode.key);

			// Move last node to root node and then start re arranging until it satisfies
			// the tree structure.
			rootNode.weight = lastNode.weight;
			rootNode.key = lastNode.key;
			nodeIndexMap.put(rootNode.key, 0);

			int currentIndex = 0;
			int size = nodes.size();
			nodes.remove(size);
			size -= 1;

			while (true) {
				int left = 2 * currentIndex - 1;
				int right = 2 * currentIndex + 1;
				if (left > size)
					break;
				if (right > size)
					right = left;

				int smallerIndex = nodes.get(left).weight <= nodes.get(right).weight ? left : right;

				if (nodes.get(currentIndex).weight > nodes.get(smallerIndex).weight) {
					swap(nodes.get(currentIndex), nodes.get(smallerIndex));
					updateNodeIndexMap(nodes.get(currentIndex).key, nodes.get(smallerIndex).key, currentIndex,
							smallerIndex);
					currentIndex = smallerIndex;
				} else {
					break;
				}
			}

		}

		private MinBinaryHeap<T>.Node extractMinNode() {
			return nodes.get(0);
		}

		public void decrease(T key, int weight) {

			int index = nodeIndexMap.get(key);
			nodes.get(index).weight = weight;
			int parentIndex = (index - 1) / 2;
			while (parentIndex >= 0) {
				if (nodes.get(parentIndex).weight > nodes.get(index).weight) {
					swap(nodes.get(parentIndex), nodes.get(index));
					updateNodeIndexMap(nodes.get(parentIndex).key, nodes.get(index).key, parentIndex, index);
					index = parentIndex;
					parentIndex = (index - 1) / 2;
				} else
					break;
			}
		}

		public Node getParent(Node node) {
			return nodes.get((nodes.indexOf(node) - 1) / 2);
		}

		public Node getLeftChild(Node node) {
			return nodes.get((nodes.indexOf(node) * 2) + 1);
		}

		public Node getRightChild(Node node) {
			return nodes.get((nodes.indexOf(node) * 2) + 2);
		}

		private void swap(Node node1, Node node2) {

			int weight = node1.weight;
			T key = node1.key;

			node1.weight = node2.weight;
			node1.key = node2.key;

			node2.weight = weight;
			node2.key = key;
		}

		public boolean contains(T key) {
			return nodeIndexMap.containsKey(key);
		}

	}

}
