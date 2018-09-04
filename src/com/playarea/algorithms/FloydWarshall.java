/**
 * 
 */
package com.playarea.algorithms;

import java.util.HashMap;
import java.util.Map;

import com.playarea.graph.DirectedWeightedGraph;
import com.playarea.graph.DirectedWeightedGraph.City;

/**
 * @author chandrashekharv
 *
 */
public class FloydWarshall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DirectedWeightedGraph graph = fillDirectedWeightedGraph();
		int[][] distanceMatrix = createdistanceMatrix(graph);
		printInitialDistanceMatrix(distanceMatrix);

		City[][] pathMatrix = applyFlodWarshallAlgorithm(distanceMatrix, graph);
		findPath(distanceMatrix, pathMatrix, graph.getCities().get(0), graph.getCities().get(5), graph);

	}

	private static void findPath(int[][] distanceMatrix, City[][] pathMatrix, City city, City city2,
			DirectedWeightedGraph graph) {
		System.out.println(distanceMatrix[graph.getCities().indexOf(city)][graph.getCities().indexOf(city2)]);
	}

	// Generates resultant path matrix & Distance matrix
	private static City[][] applyFlodWarshallAlgorithm(int[][] distanceMatrix, DirectedWeightedGraph graph) {
		City[][] pathMartix = buildInitialPathMatrix(distanceMatrix, graph);

		apply(distanceMatrix, pathMartix);

		printInitialDistanceMatrix(distanceMatrix);
		printInitialDistanceMatrix(pathMartix);

		return pathMartix;

	}

	private static void apply(int[][] distanceMatrix, City[][] pathMartix) {
		for (int k = 0; k < distanceMatrix.length; k++) {
			for (int i = 0; i < distanceMatrix.length; i++) {
				for (int j = 0; j < distanceMatrix.length; j++) {
					if ((distanceMatrix[i][j] == Integer.MAX_VALUE
							&& (distanceMatrix[i][k] != Integer.MAX_VALUE && distanceMatrix[k][j] != Integer.MAX_VALUE))
							|| ((distanceMatrix[i][j] != Integer.MAX_VALUE && distanceMatrix[i][k] != Integer.MAX_VALUE
									&& distanceMatrix[k][j] != Integer.MAX_VALUE)
									&& distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j])) {
						distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
						pathMartix[i][j] = pathMartix[k][j];
					}

				}
			}
		}
	}

	private static City[][] buildInitialPathMatrix(int[][] distanceMatrix, DirectedWeightedGraph graph) {
		// If path exists from one vertex(i) to other(j), then path[i][j] = i;
		City[][] pathMatrix = new City[distanceMatrix.length][distanceMatrix.length];

		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				pathMatrix[i][j] = (distanceMatrix[i][j] == Integer.MAX_VALUE || distanceMatrix[i][j] == 0) ? null
						: graph.getCities().get(i);
				System.out.print(pathMatrix[i][j] + " ");
			}
			System.out.println();
		}

		return pathMatrix;
	}

	private static <T extends Object> void printInitialDistanceMatrix(T[][] distanceMatrix) {
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				if (null != distanceMatrix[i][j])
					System.out.print(((City) distanceMatrix[i][j]).getName() + " \t");
				else
					System.out.print("N" + " \t");
			}
			System.out.println();
		}
	}

	private static void printInitialDistanceMatrix(int[][] distanceMatrix) {
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				System.out.print(distanceMatrix[i][j] + " \t");
			}
			System.out.println();
		}
	}

	private static DirectedWeightedGraph fillDirectedWeightedGraph() {
		String[] cities = { "BLR", "HYD", "MUM", "DEL", "CHE", "VIJ", "AHM" };
		DirectedWeightedGraph graph = new DirectedWeightedGraph(cities);
		City BLR = new City("BLR");
		City HYD = new City("HYD");
		City MUM = new City("MUM");
		City DEL = new City("DEL");
		City CHE = new City("CHE");
		City VIJ = new City("VIJ");
		City AHM = new City("AHM");
		graph.setCities(BLR, HYD, MUM, DEL, CHE, VIJ, AHM);
		graph.addEdgeBetweenTwoCities(BLR, HYD, 400);
		graph.addEdgeBetweenTwoCities(HYD, VIJ, 200);
		graph.addEdgeBetweenTwoCities(MUM, DEL, 500);
		graph.addEdgeBetweenTwoCities(DEL, CHE, 600);
		graph.addEdgeBetweenTwoCities(BLR, MUM, 300);
		graph.addEdgeBetweenTwoCities(AHM, DEL, 500);
		graph.addEdgeBetweenTwoCities(MUM, AHM, 400);
		graph.addEdgeBetweenTwoCities(DEL, VIJ, 700);
		graph.addEdgeBetweenTwoCities(CHE, MUM, 400);

		return graph;
	}

	private static int[][] createdistanceMatrix(DirectedWeightedGraph graph) {

		Map<City, Integer> cityIndexMap = new HashMap<>();
		int count = 0;
		for (City city : graph.getCities()) {
			cityIndexMap.put(city, count++);
			System.out.print(city.getName() + " \t");
		}
		System.out.println();
		int n = graph.getCities().size();
		int[][] distanceMatrix = new int[n][n];

		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				distanceMatrix[i][j] = Integer.MAX_VALUE;
			}
		}

		graph.getCities().stream().forEach(city -> {
			distanceMatrix[cityIndexMap.get(city)][cityIndexMap.get(city)] = 0;
			graph.getAdjacentListMap().get(city).forEach(edge -> {
				distanceMatrix[cityIndexMap.get(city)][cityIndexMap.get(edge.getDestination())] = edge.getWeight();
			});

		});

		return distanceMatrix;
	}

}
