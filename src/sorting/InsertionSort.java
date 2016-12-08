package sorting;

import util.PrintUtils;
import util.TimeLog;

public class InsertionSort {

	public static void main(String[] args) {

		int[] input = {9,8,7,6,5,4,3,2,1};
		
		TimeLog tl =  TimeLog.start();
		input = sort(input);		
		tl.end();
	}

	public static int[] sort(int[] input) {
		for(int i = 1; i< input.length; i++) {
			int temp = input[i];
			for(int j = i-1; j >= 0; j-- ) {
				input[j+1] = input[j];
				if(j==0 || temp > input[j-1]) {
					input[j] = temp;
					break;
				}
			}
			PrintUtils.printArray(input);
		}
		return input;
	}

}
