/**
 * 
 */
package com.playarea.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.playarea.BreadthFirstSearch;
import com.playarea.DepthFirstSearch;
import com.playarea.graph.DirectedWeightedGraph.City;

/**
 * @author chandrashekharv
 *
 */
public class UndirectedGraph {

	private LinkedList<City>[] adjacentList;

	private int totalCities; // Number of vertices
	private Map<City, Integer> indexCityMap = new HashMap<>();
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


	public LinkedList<City>[] getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(LinkedList<City>[] adjacentList) {
		this.adjacentList = adjacentList;
	}

	public int getTotalCities() {
		return totalCities;
	}

	public void setTotalCities(int totalCities) {
		this.totalCities = totalCities;
	}

	public Map<City, Integer> getIndexCityMap() {
		return indexCityMap;
	}

	public void setIndexCityMap(Map<City, Integer> indexCityMap) {
		this.indexCityMap = indexCityMap;
	}

	@SuppressWarnings("unchecked")
	public UndirectedGraph(String[] cities) {
		super();
		totalCities = cities.length;
		adjacentList = new LinkedList[totalCities];
		init(cities);
	}

	private void init(String[] cities) {
		for (int i = 0; i < totalCities; i++) {
			City city = new City(cities[i]);
			adjacentList[i] = new LinkedList<>();
			adjacentList[i].addFirst(city);
			indexCityMap.put(city, i);
		}
	}

	private void addEdgeBetweenTwoCities(City city1, City city2) {
		adjacentList[indexCityMap.get(city1)].add(city2);
		adjacentList[indexCityMap.get(city2)].add(city1);

	}

	private void print() {
		for (int v = 0; v < this.totalCities; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (City pCrawl : this.adjacentList[v]) {
				System.out.print(" -> " + pCrawl.name);
			}
			System.out.println("\n");
		}

	}

	public static void main(String[] args) {
		String[] cities = { "BLR", "HYD", "MUM", "DEL", "CHE", "VIJ", "AHM" };
		UndirectedGraph graph = new UndirectedGraph(cities);
		City BLR = new City("BLR");
		City HYD = new City("HYD");
		City MUM = new City("MUM");
		City DEL = new City("DEL");
		City CHE = new City("CHE");
		City VIJ = new City("VIJ");
		City AHM = new City("AHM");
		graph.addEdgeBetweenTwoCities(BLR, HYD);
		graph.addEdgeBetweenTwoCities(HYD, VIJ);
		graph.addEdgeBetweenTwoCities(MUM, DEL);
		graph.addEdgeBetweenTwoCities(DEL, CHE);
		graph.addEdgeBetweenTwoCities(BLR, MUM);
		graph.addEdgeBetweenTwoCities(AHM, DEL);
		graph.addEdgeBetweenTwoCities(MUM, AHM);
		graph.addEdgeBetweenTwoCities(DEL, VIJ);
		graph.addEdgeBetweenTwoCities(CHE, MUM);
		graph.print();

		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		System.out.println(breadthFirstSearch.bfs(graph, cities.length, CHE, AHM));
		
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		System.out.println(depthFirstSearch.dfs(graph, CHE, AHM));
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
