package problems;

import util.PrintUtils;

public class CoinChange {

	public static void main(String[] args) {
		int[] denoms = {2, 1};
		System.out.println(minCoinsRequired(denoms, 7));
	}
	
	public static int minCoinsRequired(int[] denoms, int total) {
		int[] counter = new int[total + 1];
		for (int i = 0 ; i < counter.length; i++ ) {
			counter[i] = Integer.MAX_VALUE;
		}
		
		for (int denom : denoms) {
			for (int i = denom; i < counter.length; i++) {
				int val = counter[i];
				int remainder = i - denom;
				if(remainder == 0) {
					val = 1;
				} else if (counter[remainder] != Integer.MAX_VALUE) {
					val = 1 + counter[remainder];
				}
				counter[i] = Math.min(val, counter[i]);
			}
		}
		return counter[total];
	}
}
