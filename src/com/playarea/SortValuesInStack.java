/**
 * 
 */
package com.playarea;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;

/**
 * @author chandrashekharv
 *
 */
public class SortValuesInStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<Integer> numbers = new Stack<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			numbers.push(random.nextInt(100));
		}
		sortStack(numbers);

		numbers.forEach(System.out::println);
	}

	private static void sortStack(Stack<Integer> numbers) {

		if (!numbers.isEmpty()) {
			int temp = numbers.pop();
			sortStack(numbers);
			sortStackInsert(numbers, temp);
		}
	}

	private static void sortStackInsert(Stack<Integer> numbers, int element) {

		if (numbers.isEmpty() || element > numbers.peek())
			numbers.push(element);
		else {
			int temp = numbers.pop();
			sortStackInsert(numbers, element);
			numbers.push(temp);

		}

	}

}
