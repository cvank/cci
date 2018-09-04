/**
 * 
 */
package com.playarea;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chandrashekharv
 *
 */
public class WordBreak {
	private static Map<String, Integer> dictionary = new HashMap<>();
	static {
		dictionary.put("i", 1);
		dictionary.put("a", 1);
		dictionary.put("am", 1);
		dictionary.put("super", 1);
		dictionary.put("hero", 1);
		dictionary.put("per", 1);
		dictionary.put("her", 1);
		dictionary.put("as", 1);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "iamasuperhero";
		// System.out.println(wordBreak(s));
		long start = System.currentTimeMillis();
		System.out.println(wordBreakReturnProperSentence(s));
		long end = System.currentTimeMillis();
		System.out.println(start);
		System.out.println(end);
		System.out.println("Total time:" + (end - start));

	}

	private static boolean wordBreak(String s) {

		if (dictionaryContains(s)) {
			System.out.println("contains :" + s);
			return true;
		} else
			for (int i = 1; i < s.length(); i++) {
				if (dictionaryContains(s.substring(0, i))) {
					System.out.println("contains :" + s.substring(0, i));
					if (wordBreak(s.substring(i))) {
						System.out.println("contains: " + s.substring(i));
						return true;
					}
				}
			}
		return false;
	}

	private static Map<String, String> cache = new HashMap<>();
	private static Map<String, String> cache1 = new HashMap<>();

	static int count = 0;

	private static String wordBreakReturnProperSentence(String s) {

		if (dictionaryContains(s)) {
			return s;
		}

		if (cache1.containsKey(s)) {
			System.out.println("returning from cache 1:"+ s + ": "+ cache1.get(s));  
			return cache1.get(s);
		}
		else
			for (int i = 1; i < s.length(); i++) {
				String prefix = s.substring(0, i);
				if (dictionaryContains(prefix)) {
					String remainingSentence = s.substring(i);
					String suffix = null;
					if (cache.containsKey(remainingSentence)) {
						suffix = cache.get(remainingSentence);
						System.out.println(count++);
					} else {
						suffix = wordBreakReturnProperSentence(remainingSentence);
						cache.put(remainingSentence, suffix);
						System.out.println("Cache:" + cache);
					}
					if (!suffix.equals("None")) {
						cache1.put(s, prefix + " " + suffix);
						return prefix + " " + suffix.intern();
					}
				}
			}
		cache1.put(s, "None");
		return "None";
	}

	private static boolean dictionaryContains(String s) {
		return dictionary.containsKey(s);
	}

}
