/**
 * 
 */
package com.playarea;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import com.playarea.graph.UndirectedGraph;
import com.playarea.graph.UndirectedGraph.City;

/**
 * @author chandrashekharv
 *
 */
public class BreadthFirstSearch {

	public String bfs(UndirectedGraph graph, int totalVertices, City source, City destination) {
		Map<City, Boolean> visitedMap = new HashMap<>();
		visitedMap.put(source, true);

		StringBuilder builder = new StringBuilder();
		LinkedList<City> yetToVisitQueue = new LinkedList<>();
		yetToVisitQueue.add(source);
		while (yetToVisitQueue.size() != 0) {
			source = yetToVisitQueue.poll();
			builder.append(source.getName() + " ");
			if (source.equals(destination))
				break;
			Iterator<City> connectedCities = graph.getAdjacentList()[graph.getIndexCityMap().get(source)].iterator();
			while (connectedCities.hasNext()) {
				City child = connectedCities.next();
				if (!visitedMap.containsKey(child)) {
					visitedMap.put(child, true);
					yetToVisitQueue.add(child);
				}
			}
		}
		return builder.toString();
	}

	public String bfs(UndirectedGraph graph, int totalVertices, City source) {
		Map<City, Boolean> visitedMap = new HashMap<>();
		visitedMap.put(source, true);

		StringBuilder builder = new StringBuilder();
		LinkedList<City> yetToVisitQueue = new LinkedList<>();
		yetToVisitQueue.add(source);
		while (yetToVisitQueue.size() != 0) {
			source = yetToVisitQueue.poll();
			builder.append(source.getName() + " ");
			Iterator<City> connectedCities = graph.getAdjacentList()[graph.getIndexCityMap().get(source)].iterator();
			while (connectedCities.hasNext()) {
				City child = connectedCities.next();
				if (!visitedMap.containsKey(child)) {
					visitedMap.put(child, true);
					yetToVisitQueue.add(child);
				}
			}
		}
		return builder.toString();
	}
}
