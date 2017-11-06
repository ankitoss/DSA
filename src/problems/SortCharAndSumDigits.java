package problems;

public class SortCharAndSumDigits {

	public static void main(String[] args) {
		reorder("ACCBA10D2EW30".toLowerCase());
	}

	public static void reorder(String input) {
		int[] map = new int[26];
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c < 'a' || c > 'z') {
				sum += (c - '0');
			} else {
				map[c - 'a'] = map[c - 'a'] + 1;
			}
		}
		String res = "";
		for (int i = 0; i < map.length; i++) {
			if (map[i] != 0) {
				while (map[i]-- > 0)
					res += (char) ('a' + i);
			}
		}
		res += sum;
		System.out.println(res);
	}

}
