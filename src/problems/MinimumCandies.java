package problems;

import util.PrintUtils;

import java.util.Arrays;
import java.util.List;

public class MinimumCandies {

    public static void main(String[] args) {
        Integer[] array = {1,5,2,1};
        new MinimumCandies().candy(Arrays.asList(array));
    }

    public int candy(List<Integer> A) {
        int size = A.size();
        int[] candies = new int[size];

        Arrays.fill(candies, 1);

        for (int i = 0; i < size - 1; i++) {
            if (A.get(i + 1) > A.get(i))
                candies[i + 1] = candies[i] + 1;
        }

        for (int i = size - 1; i > 0; i--) {
            if (A.get(i - 1) > A.get(i) && candies[i - 1] <= candies[i])
                candies[i - 1] = candies[i] + 1;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += candies[i];
        }
        return sum;
    }
}