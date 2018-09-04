/**
 * 
 */
package com.playarea;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chandrashekharv
 *
 *         An alternating parity permutation is a permutation in which any two
 *         adjacent elements have different parity. That is, one of them is odd
 *         and the other one is even. For example, [1,2,3,4], [1], [3,2,1]
 *         exhibit alternating parity while [1,3,2], [4,2,1,3] do not.
 * 
 * 
 * 
 *         Your task is to, for a given integer n, find all alternating parity
 *         permutations of the first n positive integers. Sort the results in
 *         lexicographical order.
 * 
 *         For example, consider n = 4. The following are alternating parity
 *         permutations, sorted:
 * 
 *         [1, 2, 3, 4] [1, 4, 3, 2] [2, 1, 4, 3] [2, 3, 4, 1] [3, 2, 1, 4] [3,
 *         4, 1, 2] [4, 1, 2, 3] [4, 3, 2, 1]
 * 
 * 
 *         Any other permutation will result in adjacent elements sharing the
 *         same parity.
 * 
 * 
 * 
 *         Function Description
 * 
 *         Complete the function alternatingParityPermutations in the editor
 *         below. The function must return an array of all alternating parity
 *         permutations of the first n positive integers in a lexicographically
 *         sorted order. Each permutation is an array of n elements.
 * 
 * 
 * 
 *         alternatingParityPermutations has the following parameter(s):
 * 
 *         n: the integer upper bound of the range of positive integers to
 *         consider
 * 
 * 
 * 
 *         Constraints
 * 
 * 
 *         1 ≤ n ≤ 11
 * 
 * 
 *         Input Format Format for Custom Testing Input from stdin will be
 *         processed as follows and passed to the function.
 * 
 * 
 * 
 *         The one line of input contains an integer n, the upper bound of
 *         positive integers to permute.
 * 
 *         Sample Case 0 Sample Input 0
 * 
 *         1
 * 
 * 
 *         Sample Output 0
 * 
 *         1
 * 
 * 
 *         Explanation 0
 * 
 *         There is only one permutation of a single integer 1, and it is a
 *         valid one because every two adjacent elements have different parity -
 *         in this case, there are no adjacent elements, so the condition is
 *         automatically fulfilled.
 * 
 * 
 * 
 *         Sample Case 1 Sample Input 1
 * 
 *         2
 * 
 * 
 *         Sample Output 1
 * 
 *         1 2 2 1
 * 
 * 
 *         Explanation 1
 * 
 *         There are two permutations of integers [1,2] and for each of them,
 *         the only pair of adjacent elements differ in parity. Both of these
 *         permutations are returned as a result.
 * 
 * 
 */
public class AlternatingParityPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 6;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;

		}
		Set<int[]> permutations = new HashSet<>();
		permutations(a, permutations);

		for (int[] arr : permutations) {
			Arrays.stream(arr).forEach(System.out::print);
			System.out.println();
		}
	}

	private static Map<StringBuilder, int[]> mapper = new HashMap<>();

	static int counter = 1;

	private static void permutations(int[] a, Set<int[]> permutations) {
		System.out.println("Call :" + (counter++));
		if (a == null)
			return;

		alreadyVisited.add(Arrays.toString(a));
		
		permutations.add(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				int[] swap = swap(a, i, j, permutations);
				
				if (swap == null)
					continue;
				permutations(swap, permutations);
			}

		}
	}

	private static Set<String> alreadyVisited = new HashSet<>();
	private static int count = 1;

	private static int[] swap(int[] a, int i, int j, Set<int[]> permutations) {
		int b[] = Arrays.copyOf(a, a.length);
		int temp = b[i];
		b[i] = b[j];
		b[j] = temp;
		if (!alreadyVisited.contains(Arrays.toString(b))) {
			alreadyVisited.add(Arrays.toString(b));
			System.out.println(Arrays.toString(b) + ":" + (count++));
			permutations.add(b);
			return b;
		}
		return null;

	}

}
