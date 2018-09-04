package com.playarea;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author chandrashekharv
 * 
 *         Given a string, find the length of the longest substring without
 *         repeating characters.
 * 
 *         Examples:
 * 
 *         Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 *         Given "bbbbb", the answer is "b", with the length of 1.
 * 
 *         Given "pwwkew", the answer is "wke", with the length of 3. Note that
 *         the answer must be a substring, "pwke" is a subsequence and not a
 *         substring.
 *
 */
public class LongestSubStringWithOutRepeatingChars {

	public static void main(String[] args) {
		String s = "dvadaf";

		/*String longestSubString = longestSubString(s);

		System.out.println(longestSubString);*/
		
		System.out.println(lengthOfLongestSubstring(s));  
	}

	private static String longestSubString(String s) {
		if (s == null || s.trim() == "")
			return s;

		StringBuilder builder = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder longestSoFar = null;

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
				builder.append(s.charAt(i));
			} else {
				if (map.get(s.charAt(i)) == 0) { // match at first
					builder = new StringBuilder(builder.substring(1, i));
				} else if (map.get(s.charAt(i)) > 0) {// match in the middle
					String left1 = builder.substring(0, builder.indexOf(String.valueOf(s.charAt(i))));
					String right1 = builder.substring(builder.indexOf(String.valueOf(s.charAt(i))));
					if (left1.length() > right1.length())
						longestSoFar = (longestSoFar == null || longestSoFar.length() < left1.length())
								? new StringBuilder(left1)
								: longestSoFar;
					else
						builder = new StringBuilder(right1);
				}
				map.remove(s.charAt(i));
				map.put(s.charAt(i), i);
				builder.append(s.charAt(i));
			}
		}

		return (longestSoFar != null && longestSoFar.length() > builder.length()) ? longestSoFar.toString()
				: builder.toString();
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
