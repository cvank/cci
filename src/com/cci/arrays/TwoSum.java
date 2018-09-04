package com.cci.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 5, 4, 8, 1, 9 };
		twoSum(nums, 9).forEach(t -> System.out.println(t.ele1 + " " + t.ele2));

		twoSumWithIndex(nums, 9);
	}

	private static List<Tuple> twoSum(int[] nums, int target) {

		int currentIndex = 0;
		int element = Integer.MIN_VALUE;
		List<Tuple> results = new ArrayList<>();
		int copyArray[] = null;
		int resultIndex = 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			currentIndex = i;
			if (target < nums[i])
				continue;
			if (target == nums[i])
				results.add(new Tuple(nums[currentIndex], -1));
			else {
				element = binarySearch(nums, target - nums[i]);
				if (element > 0) {
					results.add(new Tuple(nums[currentIndex], element));
				}
			}
		}

		return results;
	}

	private static int binarySearch(int[] array, final int target) {

		int startIndex = 0;

		int endIndex = array.length - 1;

		while (startIndex <= endIndex) {
			int mid = (startIndex + endIndex) / 2;

			if (target < array[mid])
				endIndex = mid - 1;
			else if (target > array[mid])
				startIndex = mid + 1;
			else
				return array[mid];
		}

		return -(startIndex + 1);
	}

	public static class Tuple {
		private int ele1;

		private int ele2;

		public Tuple(int ele1, int ele2) {
			super();
			this.ele1 = ele1;
			this.ele2 = ele2;
		}

		public int getEle1() {
			return ele1;
		}

		public void setEle1(int ele1) {
			this.ele1 = ele1;
		}

		public int getEle2() {
			return ele2;
		}

		public void setEle2(int ele2) {
			this.ele2 = ele2;
		}

	}

	private static void twoSumWithIndex(int[] a, int target) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			hashMap.merge(a[i], 1, Math::addExact);
		}

		for (int i = 0; i < a.length; i++) {
			if (hashMap.containsKey(target - a[i]))
				System.out.println("{" + a[i] + " " + (target - a[i]) + "}");
		}

	}
}
