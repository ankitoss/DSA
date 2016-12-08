package util;

import java.util.stream.IntStream;

public class PrintUtils {
	
	public static void printArray(int[] input) {
		IntStream.range(0, input.length).forEach((i) -> {
			System.out.print(input[i] + " ");
		});
		System.out.println();
	}
}
