package problems;

public class MinimumEdit {

	public static void main(String[] args) {
		String a = "geek";
		String b = "gesek";
		map = new Integer[a.length()][b.length()];
		//System.out.println(editCount(a, b, 0, 0));
		System.out.println(editCountOptimized(a, b, 0, 0));
	}
	
	private static int editCount(String first, String matchWith, int cur1, int cur2) {
		if(cur1 == first.length() || cur2 == matchWith.length()) {
			return Math.abs(Math.abs(first.length() - cur1) - Math.abs(matchWith.length() - cur2));
		}
		
		if(first.charAt(cur1) == matchWith.charAt(cur2)) {
			return editCount(first, matchWith, cur1 + 1, cur2 + 1);
		}

		int ins = editCount(first, matchWith, cur1, cur2 + 1);
		int del = editCount(first, matchWith, cur1 + 1, cur2);
		int change = editCount(first, matchWith, cur1 + 1, cur2 + 1);
		
		return 1 + Math.min(del, Math.min(ins, change));
	}
	
	
	private static Integer[][] map;
	private static int editCountOptimized(String first, String matchWith, int cur1, int cur2) {
		if(cur1 == first.length() || cur2 == matchWith.length()) {
			return Math.abs(Math.abs(first.length() - cur1) - Math.abs(matchWith.length() - cur2));
		}
		
		if(map[cur1][cur2] != null) {
			return map[cur1][cur2];
		}
		
		
		if(first.charAt(cur1) == matchWith.charAt(cur2)) {
			return editCountOptimized(first, matchWith, cur1 + 1, cur2 + 1);
		}

		int ins = editCountOptimized(first, matchWith, cur1, cur2 + 1);
		int del = editCountOptimized(first, matchWith, cur1 + 1, cur2);
		int change = editCountOptimized(first, matchWith, cur1 + 1, cur2 + 1);
		
		int min = 1 + Math.min(del, Math.min(ins, change));
		map[cur1][cur2] = min;
		return min;
	}
}
