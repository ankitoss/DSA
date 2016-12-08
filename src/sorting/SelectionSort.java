package sorting;

import util.PrintUtils;
import util.TimeLog;

public class SelectionSort {

	public static void main(String[] args) {

		int[] input = {9,8,7,6,5,4,3,2,1};
		
		TimeLog tl =  TimeLog.start();
		input = sort(input);		
		tl.end();
	}

	public static int[] sort(int[] input) {
		for(int i = 0; i< input.length-1; i++) {
			for(int j = i+1; j < input.length; j++ ) {
				if(input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
			PrintUtils.printArray(input);
		}
		return input;
	}
}
