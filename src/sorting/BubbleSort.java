package sorting;

import util.PrintUtils;
import util.TimeLog;

public class BubbleSort {

	public static void main(String[] args) {

		int[] input = {9,8,7,6,5,4,3,2,1};
		
		TimeLog tl =  TimeLog.start();
		input = sort(input);		
		tl.end();
	}
	
	public static int[] sort(int[] input) {
		for(int i = 0; i< input.length - 1; i++) {
			for(int j = 0; j < input.length - i - 1/*NOTE we don't need to iterate right most sorted elements, thus -i*/; j++ ) {
				if(input[j] > input[j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j + 1] = temp;
				}
			}
			PrintUtils.printArray(input);
		}
		return input;
	}
}