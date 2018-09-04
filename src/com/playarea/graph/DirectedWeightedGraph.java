/**
 * 
 */
package com.playarea.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author chandrashekharv
 *
 */
public class DirectedWeightedGraph {

	private Map<City, ArrayList<Edge>> adjacentListMap;
	private List<City> cities;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	

	public void setCities(City... cities) {
		this.cities = Arrays.asList(cities); 
	}

	public Map<City, ArrayList<Edge>> getAdjacentListMap() {
		return adjacentListMap;
	}

	public void setAdjacentListMap(Map<City, ArrayList<Edge>> adjacentListMap) {
		this.adjacentListMap = adjacentListMap;
	}

	public DirectedWeightedGraph(String[] cities) {
		super();
		adjacentListMap = new HashMap<>();
		init(cities);
	}

	private void init(String[] cities) {
		for (int i = 0; i < cities.length; i++) {
			City city = new City(cities[i]);
			adjacentListMap.put(city, new ArrayList<DirectedWeightedGraph.Edge>());
		}
	}

	public void addEdgeBetweenTwoCities(City city1, City city2, final int distance) {
		adjacentListMap.get(city1).add(new Edge(city1, city2, distance));

	}

	public void print() {
		adjacentListMap.keySet().stream().forEach(city -> {
			System.out.println("Edges from City:" + city.name);
			adjacentListMap.get(city).stream()
					.forEach(edge -> System.out.println(edge.getDestination().name + " " + edge.getWeight()));
		});
	}

	public static void main(String[] args) {
		String[] cities = { "BLR", "HYD", "MUM", "DEL", "CHE", "VIJ", "AHM" };
		DirectedWeightedGraph graph = new DirectedWeightedGraph(cities);
		City BLR = new City("BLR");
		City HYD = new City("HYD");
		City MUM = new City("MUM");
		City DEL = new City("DEL");
		City CHE = new City("CHE");
		City VIJ = new City("VIJ");
		City AHM = new City("AHM");
		graph.addEdgeBetweenTwoCities(BLR, HYD, 400);
		graph.addEdgeBetweenTwoCities(HYD, VIJ, 200);
		graph.addEdgeBetweenTwoCities(MUM, DEL, 500);
		graph.addEdgeBetweenTwoCities(DEL, CHE, 600);
		graph.addEdgeBetweenTwoCities(BLR, MUM, 300);
		graph.addEdgeBetweenTwoCities(AHM, DEL, 500);
		graph.addEdgeBetweenTwoCities(MUM, AHM, 400);
		graph.addEdgeBetweenTwoCities(DEL, VIJ, 700);
		graph.addEdgeBetweenTwoCities(CHE, MUM, 400);
		graph.print();

		// BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		// System.out.println(breadthFirstSearch.bfs(graph, cities.length, BLR, CHE));
		//
		// DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		// System.out.println(depthFirstSearch.dfs(graph, BLR, CHE));
		BFSDirected directedGraphBFS = new BFSDirected();
		System.out.println(directedGraphBFS.bfs(graph, BLR, DEL));
	}

	public static class BFSDirected {
		public String bfs(DirectedWeightedGraph graph, City source, City destination) {

			Map<City, Boolean> visited = new HashMap<>();
			visited.put(source, true);

			StringBuilder builder = new StringBuilder();
			LinkedList<City> yetToVisitQueue = new LinkedList<>();
			yetToVisitQueue.add(source);
			while (yetToVisitQueue.size() != 0) {
				source = yetToVisitQueue.poll();
				builder.append(source.getName() + " ");
				if (source.equals(destination))
					break;
				Iterator<Edge> iterator = graph.adjacentListMap.get(source).iterator();
				while (iterator.hasNext()) {
					Edge child = iterator.next();
					if (!visited.containsKey(child.getDestination())) {
						visited.put(child.getDestination(), true);
						builder.append(child.getWeight() + "-->" + child.getDestination().getName());
						yetToVisitQueue.add(child.getDestination());
					}
				}
			}
			return builder.toString();
		}
	}

	public static class Edge {
		private City source;
		private City destination;
		private int weight;

		public Edge(City source, City destination, int weight) {
			super();
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		public City getSource() {
			return source;
		}

		public void setSource(City source) {
			this.source = source;
		}

		public City getDestination() {
			return destination;
		}

		public void setDestination(City destination) {
			this.destination = destination;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

	}

	public static class City {
		private String name;

		public City(String cityName) {
			super();
			this.name = cityName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			City other = (City) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	}

}
