package util;

import pojo.SinglyLinkedListNode;

import java.util.stream.IntStream;

public class PrintUtils {
	
	public static void printArray(int[] input) {
		IntStream.range(0, input.length).forEach((i) -> {
			System.out.print(input[i] + " ");
		});
		System.out.println();
	}

	public static void printList(SinglyLinkedListNode node) {
		StringBuilder sb = new StringBuilder("[");

		SinglyLinkedListNode next = node;
		while (next != null) {
			sb.append(next.val);
			if(next.next != null) {
				sb.append("->");
			}
			next = next.next;
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
}
