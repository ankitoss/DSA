package problems;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		printLength("nematode knowledge", "nano");
	}

	private static Integer[][] subres;

	public static void printLength(String a, String b) {
		subres = new Integer[a.length()][b.length()];
		System.out.println(length(a, b, a.length() - 1, b.length() - 1));
		// System.out.println(lengthWithMemorization(a, b, a.length() -1, b.length() - 1));
	}

	private static int length(String p, String q, int curP, int curQ) {
		if (curP < 0 || curQ < 0) {
			return 0;
		}

		if (p.charAt(curP) == q.charAt(curQ)) {
			// System.out.println(">" + p.charAt(curP));
			return 1 + length(p, q, curP - 1, curQ - 1);
		} else {
			return Math.max(length(p, q, curP - 1, curQ), length(p, q, curP, curQ - 1));
		}
	}

	private static int lengthWithMemorization(String p, String q, int curP, int curQ) {
		throw new UnsupportedOperationException();
		/*
		 * int result = 0; if(subres[curP][curQ] != null) { System.out.println("opt");
		 * return subres[curP][curQ]; }
		 * 
		 * if(curP < 0 || curQ < 0) { result = 0; }
		 * 
		 * if(p.charAt(curP) == q.charAt(curQ)) { //System.out.println(">" +
		 * p.charAt(curP)); result = 1 + length (p, q, curP - 1, curQ - 1); } else {
		 * result = Math.max(length(p, q, curP - 1, curQ), length(p, q, curP, curQ -
		 * 1)); }
		 * 
		 * subres[curP][curQ] = result;
		 * 
		 * return result;
		 */

	}

}
