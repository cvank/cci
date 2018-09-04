/**
 * 
 */
package com.playarea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chandrashekharv
 *
 */
public class StringPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 11;
		Character a[] = new Character[n];
		char charA = 'a';
		for (int i = 0; i < n; i++) {
			a[i] = (char) ((int) charA + i);

		}
		
		Set<Character[]> permutations = new HashSet<>();
		permutations(a, permutations);

		for (Character[] arr : permutations) {
			Arrays.stream(arr).forEach(System.out::print);
			System.out.println();
		}
	}

	private static void permutations(Character[] a, Set<Character[]> permutations) {
		if (a == null)
			return;
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				Character[] swap = swap(a, i, j, permutations);
				if(swap == null)
					continue;
				permutations(swap(a, i, j, permutations), permutations);
			}
		}
	}

	private static Set<String> alreadyVisited = new HashSet<>();
	private static int count = 1;

	private static Character[] swap(Character[] a, int i, int j, Set<Character[]> permutations) {
		Character b[] = Arrays.copyOf(a, a.length);
		char temp = b[i];
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
