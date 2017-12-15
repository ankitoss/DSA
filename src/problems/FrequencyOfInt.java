package problems;

public class FrequencyOfInt {

	public static void main(String[] args) {
//		 int[] input = {2,3,3,5,5,5,6,7,7,8};
		int[] input = { 7, 7, 7, 7, 7, 7, 7 };

		int value = 7;
		int pos = getPos(value, input, 0, input.length);
		int left = getLeft(value, input, 0, pos);
		int right = getRight(value, input, pos, input.length - 1);
		System.out.println("Pos: " + pos);
		System.out.println("Left: " + left);
		System.out.println("Right: " + right);
		System.out.println("Frequency: " + (right - left + 1));
	}

	public static int getPos(int val, int[] input, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		int midval = input[mid];
		if (midval == val) {
			return mid;
		} else if (midval < val) {
			return getPos(val, input, mid + 1, end);
		} else {
			return getPos(val, input, start, mid - 1);
		}
	}

	public static int getLeft(int val, int[] input, int start, int end) {
		if (end == 0 || input[end - 1] != val) {
			return end;
		}

		int mid = (start + end) / 2;
		if (input[mid] == val) {
			end = mid;
			if(input[mid - 1] == val) {
				end--;
			}
		} else {
			start = mid;
		}
		return getLeft(val, input, start, end);
	}

	public static int getRight(int val, int[] input, int start, int end) {
		if (start == input.length - 1 || input[start + 1] != val) {
			return start;
		}

		int mid = (start + end) / 2;
		if (input[mid] == val) {
			start = mid;
			if(input[mid + 1] == val) {
				start++;
			}
		} else {
			end = mid;
		}
		return getRight(val, input, start, end);
	}
}
