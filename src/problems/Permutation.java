package problems;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

	public static void main(String[] args) {
		permute("abc");
	}

	public static void permute(String str) {
		permute(str, 0);
	}

	private static void permute(String str, int l) {
		if (l == str.length() - 1) {
			System.out.println(str);
		} else {
			for (int i = l; i < str.length(); i++) {
				String str1 = swap(str, l, i);
				permute(str1, l + 1);
			}
		}
	}

	private static String swap(String str, int pos1, int pos2) {
		char a = str.charAt(pos1);
		char b = str.charAt(pos2);

		StringBuffer buff = new StringBuffer(str);
		buff.setCharAt(pos1, b);
		buff.setCharAt(pos2, a);

		return buff.toString();
	}
}
