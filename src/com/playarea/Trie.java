package com.playarea;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Chandu on 9/11/2017.
 */
public class Trie {

	private TrieNode root;

	public Trie() {
	}

	public Trie(String[] words) {
		root = new TrieNode();
		Arrays.stream(words).parallel().forEach(word -> root.addWord(word));
	}

	public Trie(List<String> words) {
		root = new TrieNode();
		words.forEach(word -> root.addWord(word));
	}

	public TrieNode getRoot() {
		return root;
	}

	public List<String> fetch(String prefix, final boolean caseSensitive) {
		prefix = prefix.toLowerCase();
		TrieNode lastNode = root;

		StringBuilder prefixActual = new StringBuilder();
		for (int i = 0; i < prefix.length(); i++) {
			lastNode = lastNode.getChildNode(prefix.charAt(i));
			if (Objects.isNull(lastNode)) {
				return null;
			}

			prefixActual.append(lastNode.getDisplayCharacter());
		}
		suggestions(prefixActual.toString(), lastNode);
		suggestWords.forEach(System.out::println);
		return suggestWords;
	}

	CopyOnWriteArrayList<String> suggestWords = new CopyOnWriteArrayList<>();

	private void suggestions(final String prefix, TrieNode parent) {
		if (parent.isTerminated())
			suggestWords.add(prefix);

		if (parent.getChildren().size() == 0)
			return;

		for (Map.Entry<Character, TrieNode> entry : parent.getChildren().entrySet()) {
			suggestions(prefix + entry.getValue().getDisplayCharacter(), entry.getValue());

		}
	}

	public boolean findWord(String word) {

		if (null == word || word.trim() == "")
			return false;

		boolean exists = true;
		word = word.toLowerCase();

		// logic to find word.
		TrieNode node = root.getChildren().get(word.charAt(0));
		if (node != null) {
			for (int i = 1; i < word.length(); i++) {
				node = node.getChildNode(word.charAt(i));
				if (node == null) {
					exists = false;
					break;
				}

			}
			exists = exists && node.isTerminated();

		}

		return exists;
	}

}
