/**
 * 
 */
package com.playarea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chandrashekharv
 *
 */
public class AllAnagramsFromAStringArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Find all possible anagrams
		String[] s = { "stop", "pots", "tops", "spar", "rasp", "god", "dog", "tab", "bat", "flow", "wolf" };
		findAllAnagrams(s);

	}

	private static void findAllAnagrams(String[] s) {

		if (s == null || s.length == 0)
			return;

		// First loop through array and sort each word and put it as a key in the
		// hashmap and actual word as value
		// For any given word check if the sorted one exists in the map as a key
		// if exists add the actual word to the values
		// if not exists create an entry in the map for that key and word
		// loop through hashmap and print all values one by one

		// Step 1
		Map<String, List<String>> map = new HashMap<>();
		for (String word : s) {
			if (word != null && word.trim() != "")
				map.compute(sort(word), (k, v) -> {
					if (v == null)
						v = new ArrayList<>();

					v.add(word);
					return v;
				});
		}

		map.keySet().forEach(k -> System.out.println(map.get(k)));
	}

	private static String sort(String word) {
		if (word == null || word.trim() == "")
			return "";

		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
