package problems;

import util.ArrayUtils;

public class MaximumIncreasingSubsequenceSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a =  {1, 101, 2, 3, 100, 4, 5};
		System.out.println(maxSum(a));
	}

	private static int maxSum(int[] a) {
		int[] res = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			res[i] = a[i];
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) {
					res[i] = a[i] + res[j];
				}
			}
		}
		return ArrayUtils.findMax(res);
	}
}
