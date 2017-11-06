package problems;

import util.PrintUtils;

public class SubsetsOfSet {

	public static void main(String[] s) {
		int[] input = { 1, 2, 3 };
		printSubset(input);
	}

	public static void printSubset(int[] set) {
		int[] subset = {};
		subSet(set, subset, 0);
	}

	private static void subSet(int[] set, int[] subset, int index) {
		if (index == set.length) {
			return;
		}

		int valueAtIndex = set[index];
		int[] sub2 = new int[subset.length + 1];
		System.arraycopy(subset, 0, sub2, 0, subset.length);
		sub2[subset.length] = valueAtIndex;

		PrintUtils.printArray(sub2);

		subSet(set, subset, index + 1);
		subSet(set, sub2, index + 1);
	}

}
