/**
 * 
 */
package com.playarea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chandrashekharv
 *
 */
public class StringPermutationsRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "123456789";
		permutations(s);
	}

	private static void permutations(String s) {

		String prefix = "";
		String suffix = s.substring(0, s.length());

		List<String> results = new ArrayList<>();
		permutationsRecursively(prefix, suffix, results);
		results.forEach(System.out::println);
		System.out.println(results.size());
	}

	private static void permutationsRecursively(String prefix, String suffix, List<String> results) {
		if (null == suffix || suffix.length() == 0)
			results.add(prefix);
		else {
			for (int i = 0; i < suffix.length(); i++) {
				permutationsRecursively(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);
			}
		}
	}

}
