/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class FibRecusrion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;

		/*
		 * System.out.println(fib(n)); System.out.println(fibTailrecusrion(n));
		 * System.out.println(fibT2(n, 0, 1));
		 */

		int memo[] = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibmemo(n, memo));

	}

	private static int fibmemo(int n, int[] memo) {
		if (n < 2)
			return n;

		if (memo[n] != 0)
			return memo[n];
		int fibValue = fibmemo(n - 1, memo) + fibmemo(n - 2, memo);
		memo[n] = fibValue;
		return fibValue;
	}

	private static int fibTailrecusrion(int n) {
		return fibT(n, 0);

	}

	private static int fibT2(int n, int a, int b) {
		if (n == 0)
			return a;
		if (n == 1)
			return b;
		return fibT2(n - 1, b, a + b);
	}

	private static int fibT(int n, int i) {
		if (n == 0 || n == 1)
			return n + i;

		return fibT(n - 1, n + i);
	}

	private static int fib(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return n + fib(n - 1);
	}

	private static int fib2(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib2(n - 1) + fib2(n - 2);
	}

}
