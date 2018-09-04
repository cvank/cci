/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class RearrangePositiveAndNegativeNumbersInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = { 9, 8, 7, 2, 1, 3, 10, -1, -2 };
		int i = -1, temp = 0;

		// Rearrange using quick sort and taking 0 index as pivot
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int pos = i + 1;
		int neg = 0;
		if (pos == neg)
			return;

		while (pos < arr.length && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;

		}

		for (int k = 0; k < arr.length; k++)
			System.out.print(arr[k] + ", ");
	}

}
