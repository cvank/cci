/**
 * 
 */
package com.playarea.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.playarea.algorithms.DisjkstrasShortestPath.MinBinaryHeap;
import com.playarea.graph.DirectedWeightedGraph;
import com.playarea.graph.DirectedWeightedGraph.City;
import com.playarea.graph.DirectedWeightedGraph.Edge;

/**
 * @author chandrashekharv
 *
 */
public class PrimsAlgorithm {

	public List<Edge> getNeighbors(DirectedWeightedGraph graph, City sourceNode) {
		return graph.getAdjacentListMap().get(sourceNode);
	}

	public List<Edge> apply(DirectedWeightedGraph graph, City source) {

		MinBinaryHeap<City> binaryHeap = new MinBinaryHeap<>();

		for (City city : graph.getCities()) {
			binaryHeap.add(city, Integer.MAX_VALUE, city.getName());
		}

		binaryHeap.decrease(source, 0);

		Map<City, Edge> cityEdgeMap = new HashMap<>();
		List<Edge> result = new ArrayList<>();
		while (!binaryHeap.isEmpty()) {
			City currentCity = binaryHeap.extractMin();
			List<Edge> neighbors = getNeighbors(graph, currentCity);

			if (cityEdgeMap.containsKey(currentCity)) {
				result.add(cityEdgeMap.get(currentCity));
			}

			for (Edge edge : neighbors) {

				City city = edge.getDestination();

				if (binaryHeap.contains(city) && binaryHeap.getWeight(city) > edge.getWeight()) {
					binaryHeap.decrease(city, edge.getWeight());
					cityEdgeMap.put(city, edge);
				}

			}

		}

		return result;
	}
}
