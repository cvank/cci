/**
 * 
 */
package com.playarea;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chandrashekharv
 *
 */
public class FirstNonRepeatingIntegersInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 10, 9, 1, 12, 3, 4, 56, 7, 8, 9, 10, 11, 1 };

		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.compute(a[i], (k, v) -> {
				if (v != null)
					return v += 1;
				else
					return 1;

			});
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) > 1)
				continue;
			else {
				System.out.println(key);
				break;
			}
		}

	}

}
