package util;

public class ArrayUtils {

	public static int findMax(int[] input) {
		int max = 0;
		for(int i : input) {
			max = Math.max(i, max);
		}
		return max;
	}

}
