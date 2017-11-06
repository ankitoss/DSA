package problems;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

	private static Set<String> s = new HashSet<>();

	public static void main(String[] args) {
		permute("abcde");

		System.out.println(s.size());
		System.out.println(s);
	}

	public static void permute(String str) {
		permute(str, 0, 4);
	}

	private static void permute(String str, int l, int r) {
		if (l == r) {
			s.add(str);
		} else {
			for (int i = 0; i <= r; i++) {
				String str1 = swap(str, l, i);
				permute(str1, l + 1, r);
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
