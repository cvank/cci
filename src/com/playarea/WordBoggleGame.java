/**
 * 
 */
package com.playarea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author chandrashekharv
 *
 */
public class WordBoggleGame {

	static List<String> words = new ArrayList<>();
	static {
		words.addAll(Arrays.asList(new String[] { "AEON", "ANE", "ANEW", "ARE", "ATE", "AWE", "EAN", "EAR", "EARN",
				"EARNER", "EAT", "EEN", "ENATE", "ENE", "EON", "ERA", "ERN", "ERNE", "ETA", "ETCH", "EWE", "EWER",
				"EWT", "ION", "IRE", "IRON", "IRONE", "IRONER", "NAE", "NARE", "NAT", "NATCH", "NAW", "NEAR", "NEAT",
				"NEE", "NET", "NEW", "NEWER", "NEWT", "NOIR", "NOR", "NORI", "ONE", "ONER", "ORE", "RAN", "RANEE",
				"RAT", "RATCH", "RATE", "RAW", "RAWER", "REAN", "REE", "REEN", "REI", "REN", "RENEW", "REO", "RET",
				"RETCH", "REW", "REWEAR", "REX", "REZ", "RIZ", "ROE", "RONE", "TAE", "TAN", "TANE", "TAR", "TARE",
				"TARN", "TAW", "TAWER", "TEA", "TEAR", "TEE", "TEEN", "TEER", "TEN", "TENE", "TENOR", "TERN", "TERNE",
				"TEW", "TEX", "TWA", "TWAE", "TWEE", "TWEEN", "TWEER", "WAE", "WAN", "WANE", "WAR", "WARE", "WARN",
				"WARNER", "WAT", "WATCH", "WATE", "WATER", "WEAN", "WEAR", "WEE", "WEEN", "WEER", "WEET", "WEIR", "WEN",
				"WET", "WETA", "WEX", "WEXE", "ZEE", "ZEN", "ZERO", "ZEX" }));
	}

	static int[][] rowNeighbors = new int[3][3];
	static {
		rowNeighbors[0] = new int[] { -1, -1, -1 };
		rowNeighbors[1] = new int[] { 0, 0, 0 };
		rowNeighbors[2] = new int[] { 1, 1, 1 };
	}

	static int[][] colNeighbors = new int[3][3];
	static {
		colNeighbors[0] = new int[] { -1, 0, 1 };
		colNeighbors[1] = new int[] { -1, 0, 1 };
		colNeighbors[2] = new int[] { -1, 0, 1 };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trie trie = createTrie();
		int size = 4;
		char[][] charArray = new char[size][size];

		charArray[0] = new char[] { 'B', 'C', 'H', 'Q' };
		charArray[1] = new char[] { 'T', 'W', 'X', 'Z' };
		charArray[2] = new char[] { 'A', 'E', 'E', 'I' };
		charArray[3] = new char[] { 'R', 'N', 'O', 'R' };

		Set<String> used = new HashSet<>();
		List<String> resultList = new ArrayList<>();

		long start = System.currentTimeMillis();
		for (int x = 0; x < charArray.length; x++)
			for (int y = 0; y < charArray[x].length; y++) {
				resultList.addAll(findWords(charArray, "", x, y, used, trie));
			}

		resultList.forEach(System.out::println);
		System.out.println("Total time: " + (System.currentTimeMillis() - start));
	}

	private static StringBuilder printWord(TrieNode node) {
		if (node == null)
			return null;

		StringBuilder builder = new StringBuilder();
		char character = node.getCharacter();
		builder.append(character);
		for (Character character2 : node.getChildren().keySet()) {
			node = node.getChildNode(character2);
			builder.append(printWord(node));
			if (null != node && node.isTerminated()) {
				System.out.println(builder);
				return builder;
			}
			
		}
		return builder;
		

	}

	private static Trie createTrie() {
		Trie trie = new Trie(words);
		// TrieNode root = trie.addWords(words);
		return trie;

	}

	/*
	 * static class Trie { TrieNode root; static Map<String, Boolean> cache = new
	 * HashMap<>();
	 * 
	 * private TrieNode addWords(List<String> words) {
	 * 
	 * if (root == null) { root = new TrieNode(' '); } TrieNode currentNode = null;
	 * for (String word : words) { currentNode = root; int index = 0; while (index <
	 * word.length() && currentNode.charMap.containsKey(word.charAt(index))) {
	 * currentNode = currentNode.charMap.get(word.charAt(index)); index++;
	 * 
	 * } for (int i = index; i < word.length(); i++) { TrieNode valueNode = new
	 * TrieNode(word.charAt(i)); currentNode.charMap.put(word.charAt(i), valueNode);
	 * currentNode = valueNode; } currentNode.flag = true; } return root; }
	 * 
	 * private boolean findWord(final String word) {
	 * 
	 * if (null == word || word.trim() == "") return false;
	 * 
	 * if (cache.containsKey(word)) return cache.get(word);
	 * 
	 * boolean exists = true;
	 * 
	 * // logic to find word. TrieNode node = root.charMap.get(word.charAt(0)); if
	 * (node != null) { for (int i = 1; i < word.length(); i++) { node =
	 * node.charMap.get(word.charAt(i)); if (node == null) { exists = false; break;
	 * }
	 * 
	 * } exists = node != null && node.flag;
	 * 
	 * }
	 * 
	 * if (!exists) { cache.put(word, true); } else cache.put(word, false);
	 * 
	 * return exists; }
	 * 
	 * static class TrieNode { private Character val; private Map<Character,
	 * TrieNode> charMap = new HashMap<>(); boolean flag;
	 * 
	 * public TrieNode(Character val) { super(); this.val = val; }
	 * 
	 * } }
	 */

	private static Collection<? extends String> findWords(char[][] charArray, String currentWord, int x, int y,
			Set<String> used, Trie trie) {

		Set<String> found = new HashSet<>();

		// System.out.println("Checking for:" + currentWord);
		if (wordExists(trie, currentWord)) {
			found.add(currentWord);
			return found;
		}

		int nx = Integer.MIN_VALUE;
		int ny = Integer.MIN_VALUE;
		for (int i = 0; i < rowNeighbors.length; i++) {
			for (int j = 0; j < colNeighbors.length; j++) {

				if (x == 0 && y == 0 && !isUsed(x, y, used)) {
					nx = 0;
					ny = 0;
				} else {
					nx = x + rowNeighbors[i][j];
					ny = y + colNeighbors[i][j];
				}

				if (isValidCoOrdinates(nx, ny, charArray) && !isUsed(nx, ny, used)) {
					used.add(nx + "_" + ny);
					found.addAll(findWords(charArray, currentWord + charArray[nx][ny], nx, ny, used, trie));
					used.remove(nx + "_" + ny);
				}

			}
		}

		return found;
	}

	private static boolean isUsed(int nx, int ny, Set<String> used) {
		return used.contains(nx + "_" + ny);
	}

	private static boolean wordExists(Trie trie, String currentWord) {
		return trie.findWord(currentWord);
	}

	private static boolean isValidCoOrdinates(int x, int y, char[][] charArray) {
		return x >= 0 && x < charArray.length && y >= 0 && y < charArray[0].length;
	}

}
