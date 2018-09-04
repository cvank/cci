/**
 * 
 */
package com.playarea;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.playarea.graph.UndirectedGraph;
import com.playarea.graph.UndirectedGraph.City;

/**
 * @author chandrashekharv
 *
 */
public class DepthFirstSearch {

	public String dfs(UndirectedGraph graph, City source, City Destination) {

		Map<City, Boolean> visitedMap = new HashMap<>();
		StringBuilder builder = new StringBuilder();

		return dfsUtil(graph, visitedMap, source, Destination, builder);

	}

	private String dfsUtil(UndirectedGraph graph, Map<City, Boolean> visitedMap, City source, City destination,
			StringBuilder builder) {
		visitedMap.put(source, true);
		builder.append(source.getName() + " ");
		Iterator<City> iterator = graph.getAdjacentList()[graph.getIndexCityMap().get(source)].iterator();

		while (iterator.hasNext()) {
			City child = iterator.next();
			if (!visitedMap.containsKey(child)) {
				visitedMap.put(child, true);
				dfsUtil(graph, visitedMap, child, destination, builder);
			}
		}
		return builder.toString();
	}
}
